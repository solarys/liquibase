package org.liquibase.ide.common.change.action;

import liquibase.change.core.AddAutoIncrementChange;
import liquibase.change.Change;
import liquibase.database.structure.Column;
import org.liquibase.ide.common.change.wizard.RefactorWizard;
import org.liquibase.ide.common.change.wizard.page.RefactorWizardPage;

public class AddAutoIncrementAction extends BaseColumnRefactorAction {
    public AddAutoIncrementAction() {
        super("Add Auto Increment");
    }

    @Override
    public RefactorWizard createRefactorWizard(Column selectedColumn) {
        return new RefactorWizard("Make "+selectedColumn+" auto-increment");
    }

    @Override
    protected Change[] createChanges(Column column, RefactorWizardPage... pages) {
        AddAutoIncrementChange change = new AddAutoIncrementChange();
        change.setTableName(column.getTable().getName());
        change.setColumnName(column.getName());
        change.setColumnDataType(column.getDataTypeString(column.getTable().getDatabase()));

        return new Change[] { change };
    }
}
