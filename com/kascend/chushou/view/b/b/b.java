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
    private UserCard nXC;

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
        this.nXC = userCard;
    }

    public final UserCard eaB() {
        return this.nXC;
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
                Response response = (Response) d.c(str, new C0908a().getType());
                if (response != null && (userCard = (UserCard) response.data) != null) {
                    b.this.a(userCard);
                    com.kascend.chushou.view.b.b.a a = b.a(b.this);
                    if (a != null) {
                        a.a(userCard);
                        lVar = l.orN;
                    } else {
                        lVar = null;
                    }
                    if (lVar != null) {
                        return;
                    }
                }
                a(-1, "");
                l lVar2 = l.orN;
            }
        }

        @h
        /* renamed from: com.kascend.chushou.view.b.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0908a extends com.google.gson.b.a<Response<UserCard>> {
            C0908a() {
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            com.kascend.chushou.view.b.b.a a = b.a(b.this);
            if (a != null) {
                a.a();
            }
        }
    }

    public final void d() {
        com.kascend.chushou.c.c.dYm().a(this.d, this.e, this.f, new a());
    }

    public final void e() {
        UserCard.UserCardInfo userCardInfo;
        UserCard.UserCardMeta meta;
        String a2 = e.a("_fromView", "50");
        UserCard userCard = this.nXC;
        boolean isSubscribed = (userCard == null || (userCardInfo = userCard.getUserCardInfo()) == null || (meta = userCardInfo.getMeta()) == null) ? false : meta.isSubscribed();
        C0909b c0909b = new C0909b(isSubscribed);
        if (isSubscribed) {
            com.kascend.chushou.c.c.dYm().b(c0909b, (String) null, this.d, a2);
        } else {
            com.kascend.chushou.c.c.dYm().a(c0909b, (String) null, this.d, a2);
        }
    }

    @h
    /* renamed from: com.kascend.chushou.view.b.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0909b implements com.kascend.chushou.c.b {
        final /* synthetic */ boolean b;

        C0909b(boolean z) {
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
                UserCard eaB = b.this.eaB();
                if (eaB != null && (userCardInfo2 = eaB.getUserCardInfo()) != null && (meta2 = userCardInfo2.getMeta()) != null) {
                    meta2.setSubscribed(!this.b);
                }
                if (this.b) {
                    g.OF(a.i.unsubscribe_success);
                } else {
                    g.OF(a.i.subscribe_success);
                }
                com.kascend.chushou.view.b.b.a a = b.a(b.this);
                if (a != null) {
                    UserCard eaB2 = b.this.eaB();
                    if (eaB2 != null && (userCardInfo = eaB2.getUserCardInfo()) != null && (meta = userCardInfo.getMeta()) != null) {
                        z = meta.isSubscribed();
                    }
                    a.a(z);
                }
            }
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            g.y(f.b(str, a.i.subscribe_failed));
        }
    }
}
