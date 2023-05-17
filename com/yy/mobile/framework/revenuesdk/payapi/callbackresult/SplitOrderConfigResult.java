package com.yy.mobile.framework.revenuesdk.payapi.callbackresult;

import com.yy.mobile.framework.revenuesdk.payapi.bean.SplitRecordItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class SplitOrderConfigResult {
    public String bottomGuideMsg;
    public String hintMsg;
    public boolean needSplit;
    public String splitId;
    public List<SplitRecordItem> splitRecordItemList;

    public SplitOrderConfigResult() {
        this.splitRecordItemList = new ArrayList();
    }

    public SplitOrderConfigResult(boolean z, String str, String str2, List<SplitRecordItem> list, String str3) {
        this.splitRecordItemList = new ArrayList();
        this.needSplit = z;
        this.splitId = str;
        this.hintMsg = str2;
        this.splitRecordItemList = list;
        this.bottomGuideMsg = str3;
    }

    public String toString() {
        return "SplitOrderConfigResult{needSplit=" + this.needSplit + ", splitId=" + this.splitId + ", hintMsg=" + this.hintMsg + ", bottomGuideMsg=" + this.bottomGuideMsg + ", splitRecordItemList=" + this.splitRecordItemList + '}';
    }
}
