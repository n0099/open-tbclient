package com.kascend.chushou.constants;

import java.io.Serializable;
/* loaded from: classes6.dex */
public class BillBoardItem implements Serializable {
    private static final long serialVersionUID = 4158671122429529252L;
    public String mUid = "";
    public String mNickName = "";
    public String mAvatar = "";
    public String mGender = "";
    public String mRankPoint = "";
    public String mPoint = "";
    public String mSilentTypeName = "";

    public void release() {
        this.mUid = null;
        this.mNickName = null;
        this.mAvatar = null;
        this.mGender = null;
        this.mRankPoint = null;
        this.mPoint = null;
        this.mSilentTypeName = null;
    }
}
