package com.win.opensdk;

import com.win.opensdk.core.Info;
/* loaded from: classes7.dex */
public class v1 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ B1 f40443a;

    public v1(B1 b1) {
        this.f40443a = b1;
    }

    @Override // com.win.opensdk.o1
    public void a() {
    }

    @Override // com.win.opensdk.o1
    public void a(Object obj) {
        Info info = (Info) obj;
        try {
            this.f40443a.f40011c = info;
            if (this.f40443a.f40014f != null) {
                if (info == null || info.getType() != 51) {
                    this.f40443a.f40014f.onFail(PBError.PID_TYPE_ERROR);
                } else if (this.f40443a.b()) {
                    this.f40443a.f40014f.onLoaded();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.win.opensdk.o1
    public void onFail(PBError pBError) {
        r rVar = this.f40443a.f40014f;
        if (rVar != null) {
            rVar.onFail(pBError);
        }
    }
}
