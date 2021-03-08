package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.text.TextUtils;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class d implements com.yxcorp.kuaishou.addfp.a.a.a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Context f8629a;
    private /* synthetic */ a qni;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, Context context) {
        this.qni = aVar;
        this.f8629a = context;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, MOVE_EXCEPTION, IGET, CONSTRUCTOR, SGET, INVOKE, IF, SGET, CONST_STR, INVOKE, IF, SGET, INVOKE, MOVE_EXCEPTION, IGET, CONSTRUCTOR, SGET, INVOKE, IF, SGET, CONST_STR, INVOKE, IF, SGET, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
    @Override // com.yxcorp.kuaishou.addfp.a.a.a
    public final void a(boolean z, com.yxcorp.kuaishou.addfp.a.b.a aVar) {
        boolean isEmpty;
        try {
            if (z || aVar != null) {
                String b = aVar.b();
                com.yxcorp.kuaishou.addfp.android.b.b.b("get OAID " + b);
                if (!TextUtils.isEmpty(b)) {
                    a.f8593a = b;
                }
            } else {
                com.yxcorp.kuaishou.addfp.android.b.b.b("not support OAID");
            }
            com.yxcorp.kuaishou.addfp.a.a.b.eJl().b();
            if (aVar != null) {
                try {
                } catch (Throwable th) {
                    return;
                }
            }
            if (isEmpty) {
                return;
            }
        } catch (Throwable th2) {
            try {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th2);
                if (aVar != null) {
                    try {
                        aVar.d();
                    } catch (Throwable th3) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(a.f8593a) || a.f8593a.startsWith("KWE")) {
                    return;
                }
                new com.yxcorp.kuaishou.addfp.android.a.e(this.f8629a).b(a.f8593a);
            } finally {
                if (aVar != null) {
                    try {
                        aVar.d();
                    } catch (Throwable th4) {
                    }
                }
                if (!TextUtils.isEmpty(a.f8593a) && !a.f8593a.startsWith("KWE")) {
                    new com.yxcorp.kuaishou.addfp.android.a.e(this.f8629a).b(a.f8593a);
                }
            }
        }
    }
}
