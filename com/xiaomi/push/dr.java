package com.xiaomi.push;

import android.content.Context;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.tencent.connect.common.Constants;
/* loaded from: classes7.dex */
public class dr extends dq {
    public dr(Context context, int i2) {
        super(context, i2);
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hh mo172a() {
        return hh.Storage;
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo172a() {
        return Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
    }

    @Override // com.xiaomi.push.dq
    public String b() {
        return "ram:" + i.m423a() + ",rom:" + i.m427b() + FieldBuilder.SE + "ramOriginal:" + i.m429c() + ",romOriginal:" + i.d();
    }
}
