package com.mofamulu.tieba.ch;

import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements y {
    final /* synthetic */ u a;
    private final /* synthetic */ MoreVipActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, MoreVipActivity moreVipActivity) {
        this.a = uVar;
        this.b = moreVipActivity;
    }

    @Override // com.mofamulu.tieba.ch.y
    public String a(int i, String str, String str2) {
        bg bgVar;
        bg bgVar2;
        if (i == 0) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (!jSONObject.has("version")) {
                    bgVar = this.a.a;
                    bgVar.a(jSONObject);
                } else if (jSONObject.getInt("version") == 2) {
                    bgVar2 = this.a.a;
                    bgVar2.a(jSONObject.getJSONObject("settings"));
                }
                return "保存在云端的设置已经成功下载并恢复到本机。默认使用的小尾巴和自动签到帐号不支持同步，请注意重新选择。";
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
