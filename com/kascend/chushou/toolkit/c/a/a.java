package com.kascend.chushou.toolkit.c.a;

import java.io.File;
import java.util.HashMap;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
import tv.chushou.basis.d.a.a.c;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.model.RequestTag;
@h
/* loaded from: classes6.dex */
public final class a {
    private c.a pyK;

    public final void a(String str, String str2, File file, c.a aVar) {
        this.pyK = aVar;
        if (str == null || file == null) {
            c.a aVar2 = this.pyK;
            if (aVar2 != null) {
                aVar2.onFailure(-1, "", null);
                return;
            }
            return;
        }
        c.a aVar3 = this.pyK;
        if (aVar3 != null) {
            aVar3.onStart();
        }
        Http http = (Http) tv.chushou.basis.d.b.eHr().S(Http.class);
        if (http == null) {
            c.a aVar4 = this.pyK;
            if (aVar4 != null) {
                aVar4.onFailure(-1, "", null);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        http.getAsync(tv.chushou.common.a.eHs(), "api/upload/up-token.htm?", hashMap, RequestTag.normal(), new C1013a(str, str2, file));
    }

    @h
    /* renamed from: com.kascend.chushou.toolkit.c.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1013a implements tv.chushou.basis.d.a.c.a<Http.Resp> {
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ File d;

        C1013a(String str, String str2, File file) {
            this.b = str;
            this.c = str2;
            this.d = file;
        }

        @Override // tv.chushou.basis.d.a.c.a
        public void onStart() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // tv.chushou.basis.d.a.c.a
        /* renamed from: a */
        public void onSuccess(Http.Resp resp) {
            String optString;
            if ((resp != null ? resp.respJson : null) == null) {
                c.a aVar = a.this.pyK;
                if (aVar != null) {
                    aVar.onFailure(-1, "", null);
                    return;
                }
                return;
            }
            JSONObject jSONObject = resp.respJson;
            int optInt = jSONObject != null ? jSONObject.optInt("code", -1) : -1;
            JSONObject jSONObject2 = resp.respJson;
            String str = (jSONObject2 == null || (optString = jSONObject2.optString("message", "")) == null) ? "" : optString;
            JSONObject jSONObject3 = resp.respJson;
            String str2 = (jSONObject3 == null || (str2 = jSONObject3.optString("data", "")) == null) ? "" : "";
            if (optInt == 0) {
                if (str2.length() > 0) {
                    a.this.a(this.d, a.this.a(this.b, this.c), str2);
                    return;
                }
            }
            c.a aVar2 = a.this.pyK;
            if (aVar2 != null) {
                aVar2.onFailure(optInt, str, null);
            }
        }

        @Override // tv.chushou.basis.d.a.c.a
        public void onFailure(int i, String str, Throwable th) {
            c.a aVar = a.this.pyK;
            if (aVar != null) {
                aVar.onFailure(i, str, th);
            }
        }
    }

    @h
    /* loaded from: classes6.dex */
    public static final class b implements c.a {
        final /* synthetic */ String b;

        b(String str) {
            this.b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // tv.chushou.basis.d.a.c.a
        /* renamed from: a */
        public void onSuccess(String str) {
            String str2 = null;
            try {
                str2 = new JSONObject(str).optString("key");
            } catch (Exception e) {
            }
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                c.a aVar = a.this.pyK;
                if (aVar != null) {
                    aVar.onFailure(-1, "", null);
                    return;
                }
                return;
            }
            c.a aVar2 = a.this.pyK;
            if (aVar2 != null) {
                aVar2.onSuccess(this.b);
            }
        }

        @Override // tv.chushou.basis.d.a.c.a
        public void onFailure(int i, String str, Throwable th) {
            c.a aVar = a.this.pyK;
            if (aVar != null) {
                aVar.onFailure(i, str, th);
            }
        }

        @Override // tv.chushou.basis.d.a.a.c.a
        public void onProgress(int i) {
            c.a aVar = a.this.pyK;
            if (aVar != null) {
                aVar.onProgress(i);
            }
        }

        @Override // tv.chushou.basis.d.a.c.a
        public void onStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(File file, String str, String str2) {
        com.kascend.chushou.toolkit.c.a.b.pyO.ewd().a(file, str, str2, new b(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(String str, String str2) {
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            return "";
        }
        String a2 = com.kascend.chushou.d.b.a();
        if (str2 == null) {
            str2 = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("sdk/" + a2 + '/').append(str2).append("/").append(System.currentTimeMillis()).append(".jpg");
        String sb2 = sb.toString();
        q.m(sb2, "sb.toString()");
        return sb2;
    }
}
