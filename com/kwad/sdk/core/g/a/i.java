package com.kwad.sdk.core.g.a;

import com.baidu.android.imsdk.db.TableDefine;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.o;
import com.kwad.sdk.utils.v;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    private String f9471a;

    /* renamed from: b  reason: collision with root package name */
    private String f9472b;
    private int c;
    private int d;

    public static i a() {
        i iVar = new i();
        iVar.f9471a = ah.l();
        iVar.f9472b = ah.k(KsAdSDKImpl.get().getContext());
        iVar.c = v.d(KsAdSDKImpl.get().getContext());
        iVar.d = v.e(KsAdSDKImpl.get().getContext());
        return iVar;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, TableDefine.UserInfoColumns.COLUMN_IP, this.f9471a);
        o.a(jSONObject, "mac", this.f9472b);
        o.a(jSONObject, "connectionType", this.c);
        o.a(jSONObject, "operatorType", this.d);
        return jSONObject;
    }
}
