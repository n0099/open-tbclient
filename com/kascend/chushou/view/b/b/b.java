package com.kascend.chushou.view.b.b;

import com.kascend.chushou.a;
import com.kascend.chushou.bean.Response;
import com.kascend.chushou.bean.UserCard;
import com.kascend.chushou.d.e;
import com.kascend.chushou.d.f;
import com.kascend.chushou.view.base.c;
import kotlin.h;
import kotlin.l;
import org.json.JSONObject;
import tv.chushou.zues.utils.d;
import tv.chushou.zues.utils.g;
@h
/* loaded from: classes6.dex */
public final class b extends c<com.kascend.chushou.view.b.b.a> {
    private final String d;
    private final String e;
    private final String f;
    private UserCard pxS;

    public static final /* synthetic */ com.kascend.chushou.view.b.b.a a(b bVar) {
        return (com.kascend.chushou.view.b.b.a) bVar.b;
    }

    public final String f() {
        return this.d;
    }

    public final String g() {
        return this.e;
    }

    public b(String str, String str2, String str3) {
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public final void a(UserCard userCard) {
        this.pxS = userCard;
    }

    public final UserCard ewi() {
        return this.pxS;
    }

    @h
    /* loaded from: classes6.dex */
    public static final class a implements com.kascend.chushou.c.b {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a(String str, JSONObject jSONObject) {
            UserCard userCard;
            l lVar;
            if (b.this.b()) {
                Response response = (Response) d.c(str, new C1014a().getType());
                if (response != null && (userCard = (UserCard) response.data) != null) {
                    b.this.a(userCard);
                    com.kascend.chushou.view.b.b.a a2 = b.a(b.this);
                    if (a2 != null) {
                        a2.a(userCard);
                        lVar = l.pRS;
                    } else {
                        lVar = null;
                    }
                    if (lVar != null) {
                        return;
                    }
                }
                a(-1, "");
                l lVar2 = l.pRS;
            }
        }

        @h
        /* renamed from: com.kascend.chushou.view.b.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C1014a extends com.google.gson.b.a<Response<UserCard>> {
            C1014a() {
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            com.kascend.chushou.view.b.b.a a2 = b.a(b.this);
            if (a2 != null) {
                a2.a();
            }
        }
    }

    public final void d() {
        com.kascend.chushou.c.c.etT().a(this.d, this.e, this.f, new a());
    }

    public final void e() {
        UserCard.UserCardInfo userCardInfo;
        UserCard.UserCardMeta meta;
        String a2 = e.a("_fromView", "50");
        UserCard userCard = this.pxS;
        boolean isSubscribed = (userCard == null || (userCardInfo = userCard.getUserCardInfo()) == null || (meta = userCardInfo.getMeta()) == null) ? false : meta.isSubscribed();
        C1015b c1015b = new C1015b(isSubscribed);
        if (isSubscribed) {
            com.kascend.chushou.c.c.etT().b(c1015b, (String) null, this.d, a2);
        } else {
            com.kascend.chushou.c.c.etT().a(c1015b, (String) null, this.d, a2);
        }
    }

    @h
    /* renamed from: com.kascend.chushou.view.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1015b implements com.kascend.chushou.c.b {
        final /* synthetic */ boolean b;

        C1015b(boolean z) {
            this.b = z;
        }

        @Override // com.kascend.chushou.c.b
        public void a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a(String str, JSONObject jSONObject) {
            UserCard.UserCardInfo userCardInfo;
            UserCard.UserCardMeta meta;
            UserCard.UserCardInfo userCardInfo2;
            UserCard.UserCardMeta meta2;
            boolean z = false;
            if (b.this.b()) {
                UserCard ewi = b.this.ewi();
                if (ewi != null && (userCardInfo2 = ewi.getUserCardInfo()) != null && (meta2 = userCardInfo2.getMeta()) != null) {
                    meta2.setSubscribed(!this.b);
                }
                if (this.b) {
                    g.Sc(a.i.unsubscribe_success);
                } else {
                    g.Sc(a.i.subscribe_success);
                }
                com.kascend.chushou.view.b.b.a a2 = b.a(b.this);
                if (a2 != null) {
                    UserCard ewi2 = b.this.ewi();
                    if (ewi2 != null && (userCardInfo = ewi2.getUserCardInfo()) != null && (meta = userCardInfo.getMeta()) != null) {
                        z = meta.isSubscribed();
                    }
                    a2.a(z);
                }
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            g.A(f.b(str, a.i.subscribe_failed));
        }
    }
}
