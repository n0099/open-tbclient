package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes9.dex */
public class eg extends ed {
    public eg(Context context, int i) {
        super(context, i);
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public int mo166a() {
        return 23;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public ho mo166a() {
        return ho.Storage;
    }

    @Override // com.xiaomi.push.ed, com.xiaomi.push.ai.a
    /* renamed from: a */
    public String mo166a() {
        StringBuilder sb = new StringBuilder();
        sb.append("ram:").append(i.m392b()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append("rom:").append(i.m394c()).append("|").append("ramOriginal:").append(i.d()).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append("romOriginal:").append(i.e());
        return sb.toString();
    }
}
