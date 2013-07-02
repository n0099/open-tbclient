package com.mofamulu.tieba.ch;

import org.json.JSONArray;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements y {
    final /* synthetic */ u a;
    private final /* synthetic */ MoreVipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar, MoreVipActivity moreVipActivity) {
        this.a = uVar;
        this.b = moreVipActivity;
    }

    @Override // com.mofamulu.tieba.ch.y
    public String a(int i, String str, String str2) {
        bg bgVar;
        if (i == 0) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                bgVar = this.a.a;
                bgVar.a(jSONArray);
                return str;
            } catch (Throwable th) {
                return "云端返回的数据格式错误！";
            }
        }
        return str;
    }

    @Override // com.mofamulu.tieba.ch.y
    public void a(String str) {
        this.b.c(str);
    }
}
