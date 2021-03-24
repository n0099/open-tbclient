package com.xiaomi.push;

import android.content.Context;
import com.baidu.tbadk.core.util.FieldBuilder;
import com.tencent.connect.common.Constants;
/* loaded from: classes7.dex */
public class dr extends dq {
    public dr(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public hh mo165a() {
        return hh.Storage;
    }

    @Override // com.xiaomi.push.dq, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo165a() {
        return Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR;
    }

    @Override // com.xiaomi.push.dq
    public String b() {
        return "ram:" + i.m416a() + ",rom:" + i.m420b() + FieldBuilder.SE + "ramOriginal:" + i.m422c() + ",romOriginal:" + i.d();
    }
}
