package com.example.nguyenviethung_android43_btvnday7_fragment;

public class SavePresenter {
    ISave iSave;

    public SavePresenter(ISave iSave) {
        this.iSave = iSave;
    }
    public void onSave(int d){
        if(d==1){
            iSave.onSaveSuccessful("Bạn đã lưu thành công");
        }else{
            iSave.onNotSave("Thông tin không được lưu");
        }
    }
}
