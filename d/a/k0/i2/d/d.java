package d.a.k0.i2.d;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import d.a.j0.r.s.a;
/* loaded from: classes5.dex */
public class d implements d.a.k0.i2.h.a {

    /* renamed from: a  reason: collision with root package name */
    public int f56131a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f56132b = "";

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f56133c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.r.f0.a f56134d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.r.f0.c f56135e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f56136f;

    /* loaded from: classes5.dex */
    public class a implements DialogInterface.OnCancelListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            MessageManager.getInstance().removeMessage(d.this.f56136f);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements a.e {
        public b(d dVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            if (Build.VERSION.SDK_INT < 11) {
                aVar.dismiss();
                d.this.f56133c.showToast(R.string.frs_header_games_unavailable);
                return;
            }
            TiebaStatic.log("c10038");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) d.this.f56133c.getPageActivity(), 2, true, 5);
            memberPayActivityConfig.setReferPageClickZone(MemberPayStatistic.REFER_PAGE_HE_HER_PERSONAL_CENTER, MemberPayStatistic.CLICK_ZONE_POP_UPS_OPENDE_BUTTON);
            if (!StringUtils.isNULL("4010001002")) {
                memberPayActivityConfig.setSceneId("4010001002");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* renamed from: d.a.k0.i2.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1377d implements a.e {
        public C1377d(d dVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f56139e;

        public e(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f56139e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            d.this.g();
            MessageManager.getInstance().sendMessage(this.f56139e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
        public f(d dVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56133c = tbPageContext;
        d.a.j0.r.f0.c cVar = new d.a.j0.r.f0.c();
        this.f56135e = cVar;
        cVar.f49665a = 1000L;
        this.f56136f = bdUniqueId;
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001431);
        BdUniqueId bdUniqueId2 = this.f56136f;
        userMuteAddAndDelCustomMessage.mId = bdUniqueId2;
        userMuteAddAndDelCustomMessage.from = 0;
        userMuteAddAndDelCustomMessage.setTag(bdUniqueId2);
        MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001432);
        BdUniqueId bdUniqueId3 = this.f56136f;
        userMuteCheckCustomMessage.mId = bdUniqueId3;
        userMuteCheckCustomMessage.setTag(bdUniqueId3);
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    @Override // d.a.k0.i2.h.a
    public void a(int i2, int i3, String str, int i4, String str2) {
        d.a.j0.r.f0.a aVar = this.f56134d;
        if (aVar != null) {
            aVar.h(false);
        }
        this.f56131a = i3;
        this.f56132b = str;
        if (i4 == 0) {
            if (i2 == 1) {
                this.f56135e.c(this.f56133c.getString(R.string.mute_success));
            } else if (i2 == 2) {
                this.f56135e.c(this.f56133c.getResources().getString(R.string.un_mute_success));
            }
        } else if (i4 == 220017) {
            if (TextUtils.isEmpty(str2)) {
                str2 = this.f56133c.getString(R.string.mute_error_beyond_limit);
            }
            i(str2);
        } else if (i4 == 1990043) {
            h();
        } else {
            if (d.a.c.e.p.k.isEmpty(str2)) {
                if (i2 == 1) {
                    str2 = this.f56133c.getResources().getString(R.string.mute_fail);
                } else if (i2 == 2) {
                    str2 = this.f56133c.getResources().getString(R.string.un_mute_fail);
                }
            }
            this.f56135e.b(str2);
        }
    }

    public String d() {
        return this.f56132b;
    }

    public int e() {
        return this.f56131a;
    }

    public BdUniqueId f() {
        return this.f56136f;
    }

    public void g() {
        if (this.f56134d == null) {
            d.a.j0.r.f0.a aVar = new d.a.j0.r.f0.a(this.f56133c);
            this.f56134d = aVar;
            aVar.e(new a());
        }
        this.f56134d.h(true);
    }

    public void h() {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f56133c.getPageActivity());
        aVar.setMessage(this.f56133c.getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new c());
        aVar.setNegativeButton(R.string.cancel, new C1377d(this));
        aVar.create(this.f56133c).show();
    }

    public void i(String str) {
        if (str == null) {
            str = "";
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f56133c.getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new b(this));
        aVar.create(this.f56133c).show();
    }

    public void j(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2) {
        if (z) {
            g();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f56133c.getPageActivity());
        if (d.a.c.e.p.k.isEmpty(str)) {
            aVar.setMessage(this.f56133c.getResources().getString(R.string.block_mute_message_alert, str2));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new e(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new f(this));
        aVar.create(this.f56133c).show();
    }
}
