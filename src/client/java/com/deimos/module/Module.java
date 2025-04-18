package com.deimos.module;




import net.minecraft.client.MinecraftClient;

public abstract class Module {
    public String name;
    public String description;
    public Category category;
    public boolean toggled;
    public int keyCode;
    public MinecraftClient mc;

    //private List<CheckBox> options = new ArrayList<>();

    public Module(String name,String description, Category category,int keyCode){
        this.name = name;
        this.description = description;
        this.category = category;
        this.toggled = false;
        this.keyCode = keyCode;
        this.mc = MinecraftClient.getInstance();
    }
    public int getKeyCode(){
        return keyCode;
    }
    public void onEnable(){}
    public void onDisable(){}
    public void onUpdate(){}
    public abstract void setupOptions();

    public void toggle(){
        this.toggled = !this.toggled;
        if(this.toggled){
            onEnable();;
        }else{
            onDisable();
        }
    }
    public String getName(){
        return name;
    }
    public Category getCategory(){
        return category;
    }
    public boolean isToggled(){
        return toggled;
    }
    public void setToggled(boolean toggled){
        this.toggled = toggled;
    }
    public void onRender(){
        if(this.isToggled()){
            renderLogic();
        }
    }
    protected void renderLogic(){

    }
}
    /* 
    public String getDescription(){
        return description;
    }
    
    public void renderOptions(DrawContext context, int x,int y){
        int yOffset = 0;
        for(CheckBox option : options){
            option.setPostition(10, yOffset);
            option.Render(context);
            yOffset += 20;
        }
    }
    public void addOption(CheckBox checkbox){
        options.add(checkbox);
    }
    public List<CheckBox> getOptions(){
        return options;
    }
    public boolean mouseClicked(double mouseX,double mouseY,int button){
        for(CheckBox option : options){
            if(option.mouseClicked(mouseX, mouseY, button)){
                return true;
            }
        }
        return false;
    }
}
    */