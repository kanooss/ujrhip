package com.hip.ujr.ujrhip.Model

import com.hip.ujr.ujrhip.Contractor.CreateContractor
import com.hip.ujr.ujrhip.Etc.AWSS3
import com.hip.ujr.ujrhip.Item.postData

class CreateModel : CreateContractor.Model {
    private var presenter : CreateContractor.Presenter? = null
    var data = postData()
    //프레젠터
    override fun setPresenter(presenter: CreateContractor.Presenter) {
        this.presenter = presenter
    }
    //테이블 데이터 세팅
    override fun setData(userId: String?,date: Long?,password: String?,photoUrl: String?,content: String?) {
        data.setData(userId,date,password,photoUrl,content)
    }
    //사진 저장
    override fun savePhoto(photoUrl: String, path: String) {
        AWSS3.uploadWithTransferUtility(photoUrl, path)
    }
}