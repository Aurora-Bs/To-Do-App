package com.example.application.views.home;

import com.example.application.data.SamplePerson;
import com.example.application.services.SamplePersonService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.QAbstractAuditable;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.beans.JavaBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.PENCIL_RULER_SOLID)
@Uses(Icon.class)
@JavaBean
class TodoData implements Serializable {
    private String name;
    private String description;
    private String dueDate;
    public TodoData() {
        name = "To Do App";
        description = "To Do App";
        dueDate = "01/01/1970";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDueDate() {
        return dueDate;
    }
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
   
}
public class HomeView extends Composite<VerticalLayout> {

    public HomeView() {
        Grid<TodoData> stripedGrid = new Grid<>(TodoData.class);
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Button buttonPrimary3 = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        stripedGrid.addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
        stripedGrid.setWidth("100%");
        stripedGrid.getStyle().set("flex-grow", "0");
        stripedGrid.setColumns("name", "description", "dueDate");
        stripedGrid.getColumnByKey("name").setHeader("Name");
        stripedGrid.getColumnByKey("description").setHeader("Description");
        stripedGrid.getColumnByKey("dueDate").setHeader("Due Date");
// Provide a list of data
        // Create a list of TodoData objects with different values
        List<TodoData> todoList = new ArrayList<>();
        TodoData todo1 = new TodoData();
        todo1.setName("Complete Project");
        todo1.setDescription("Finish the Vaadin application");
        todo1.setDueDate("2023-12-31");

        TodoData todo2 = new TodoData();
        todo2.setName("Review Code");
        todo2.setDescription("Perform code review with team");
        todo2.setDueDate("2023-12-15");

        TodoData todo3 = new TodoData();
        todo3.setName("Deploy Application");
        todo3.setDescription("Deploy to production server");
        todo3.setDueDate("2024-01-05");

        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);

        stripedGrid.setItems(todoList);

// Set the list as items in the grid
        stripedGrid.setItems(todoList);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Add");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Edit");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("Delete");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(stripedGrid);
        getContent().add(layoutRow);
        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonPrimary2);
        layoutRow.add(buttonPrimary3);
    }
}
