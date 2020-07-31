package com.kascend.chushou.constants;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ManagerBean {
    public boolean mIsCreator = false;
    public ArrayList<BillBoardItem> mBillBoardItemList = new ArrayList<>();

    public void release() {
        this.mIsCreator = false;
        if (this.mBillBoardItemList != null) {
            this.mBillBoardItemList.clear();
            this.mBillBoardItemList = null;
        }
    }
}
