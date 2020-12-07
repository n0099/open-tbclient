package com.vivo.push.b;

import com.baidu.ala.recorder.video.AlaRecorderLog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public final class v extends u {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f4421a;
    private ArrayList<String> b;

    public v(int i) {
        super(i);
        this.f4421a = null;
        this.b = null;
    }

    public final ArrayList<String> d() {
        return this.f4421a;
    }

    public final List<String> e() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void c(com.vivo.push.a aVar) {
        super.c(aVar);
        aVar.a("content", this.f4421a);
        aVar.a(AlaRecorderLog.KEY_ERROR_MSG, this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final void d(com.vivo.push.a aVar) {
        super.d(aVar);
        this.f4421a = aVar.b("content");
        this.b = aVar.b(AlaRecorderLog.KEY_ERROR_MSG);
    }

    @Override // com.vivo.push.b.u, com.vivo.push.y
    public final String toString() {
        return "OnSetTagsCommand";
    }
}
