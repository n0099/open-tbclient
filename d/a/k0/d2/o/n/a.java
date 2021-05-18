package d.a.k0.d2.o.n;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.j0.a0.d;
import d.a.j0.r.q.a2;
import d.a.j0.r.q.d0;
import d.a.j0.r.q.l0;
import d.a.j0.r.q.v0;
import d.a.j0.r.q.w1;
import d.a.j0.r.s.a;
import d.a.j0.r.s.b;
import d.a.j0.r.s.l;
import d.a.k0.d2.k.e.f0;
import d.a.k0.d2.k.e.g0;
import d.a.k0.d2.k.e.w0;
import d.a.k0.h.f;
import d.a.k0.h.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.ForumToolPerm;
/* loaded from: classes5.dex */
public class a {
    public static int Q = 0;
    public static int R = 3;
    public d.a.c.j.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public String H;
    public Runnable I;
    public d.a.j0.r.b0.a J;
    public d.a.k0.d3.h0.e K;
    public boolean O;

    /* renamed from: a  reason: collision with root package name */
    public VideoPbFragment f53606a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.r.s.j f53607b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.r.s.l f53608c;
    public List<CustomBlueCheckRadioButton> m;
    public d.a.k0.h.f v;
    public d.a.k0.h.i w;
    public d.a.k0.d2.k.f.a x;
    public PbFragment.n2 y;
    public w0 z;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.r.s.j f53609d = null;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.r.s.a f53610e = null;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f53611f = null;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f53612g = null;

    /* renamed from: h  reason: collision with root package name */
    public d.a.j0.r.s.e f53613h = null;

    /* renamed from: i  reason: collision with root package name */
    public View f53614i = null;
    public LinearLayout j = null;
    public TextView k = null;
    public TextView l = null;
    public String n = null;
    public ScrollView o = null;
    public CompoundButton.OnCheckedChangeListener p = null;
    public d.a.j0.r.s.j q = null;
    public d.a.j0.r.f0.a r = null;
    public d.a.j0.r.s.b s = null;
    public AlertDialog t = null;
    public f0 u = null;
    public PostData G = null;
    public boolean L = d.a.j0.b.d.V();
    public final View.OnLongClickListener M = new p();
    public l.e N = new r();
    public final b.c P = new v();

    /* renamed from: d.a.k0.d2.o.n.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1266a implements a.e {
        public C1266a(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class b implements f.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f53615a;

        public b(d.a.j0.r.s.a aVar) {
            this.f53615a = aVar;
        }

        @Override // d.a.k0.h.f.g
        public void a(JSONArray jSONArray) {
            a.this.f53606a.F2(this.f53615a, jSONArray);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements i.h {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f53617a;

        public c(d.a.j0.r.s.a aVar) {
            this.f53617a = aVar;
        }

        @Override // d.a.k0.h.i.h
        public void a(JSONArray jSONArray) {
            a.this.f53606a.F2(this.f53617a, jSONArray);
        }
    }

    /* loaded from: classes5.dex */
    public class d implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f53619e;

        public d(boolean z) {
            this.f53619e = z;
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            a.this.q.dismiss();
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return;
            }
            switch (i2) {
                case 10:
                    a.this.e0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    return;
                case 11:
                    if (a.this.y != null) {
                        a.this.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                        return;
                    }
                    return;
                case 12:
                    a.this.S(this.f53619e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements b.c {
        public e() {
        }

        @Override // d.a.j0.r.s.b.c
        public void a(d.a.j0.r.s.b bVar, int i2, View view) {
            if (i2 == 0) {
                TiebaStatic.eventStat(a.this.f53606a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                a aVar = a.this;
                aVar.H = aVar.H.trim();
                UtilHelper.callPhone(a.this.f53606a.getPageContext().getPageActivity(), a.this.H);
                new d.a.k0.d2.k.e.d(a.this.f53606a.z().O0(), a.this.H, "1").start();
                bVar.e();
            } else if (i2 == 1) {
                TiebaStatic.eventStat(a.this.f53606a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                a aVar2 = a.this;
                aVar2.H = aVar2.H.trim();
                UtilHelper.smsPhone(a.this.f53606a.getPageContext().getPageActivity(), a.this.H);
                new d.a.k0.d2.k.e.d(a.this.f53606a.z().O0(), a.this.H, "2").start();
                bVar.e();
            } else if (i2 == 2) {
                a aVar3 = a.this;
                aVar3.H = aVar3.H.trim();
                UtilHelper.startBaiDuBar(a.this.f53606a.getPageContext().getPageActivity(), a.this.H);
                bVar.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.j f53622e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f53623f;

        public f(d.a.j0.r.s.j jVar, View view) {
            this.f53622e = jVar;
            this.f53623f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
            if (r4.f53624g.f53606a.z().L0() != 3) goto L5;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        @Override // d.a.j0.r.s.l.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            boolean X1;
            this.f53622e.dismiss();
            int i3 = 3;
            if (a.this.f53606a.z().L0() != 1 || i2 != 1) {
                if (a.this.f53606a.z().L0() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (a.this.f53606a.z().L0() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f53623f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (a.this.f53606a.z().y0().f52719f != null && a.this.f53606a.z().y0().f52719f.size() > i2) {
                    i2 = a.this.f53606a.z().y0().f52719f.get(i2).sort_type.intValue();
                }
                X1 = a.this.f53606a.z().X1(i2);
                this.f53623f.setTag(Integer.valueOf(a.this.f53606a.z().K0()));
                if (X1) {
                    return;
                }
                a.this.f53606a.r4(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f53623f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
            if (a.this.f53606a.z().y0().f52719f != null) {
                i2 = a.this.f53606a.z().y0().f52719f.get(i2).sort_type.intValue();
            }
            X1 = a.this.f53606a.z().X1(i2);
            this.f53623f.setTag(Integer.valueOf(a.this.f53606a.z().K0()));
            if (X1) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f53625e;

        public g(a aVar, MetaData metaData) {
            this.f53625e = metaData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f53625e.getUserId()).param("obj_locate", 2));
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f53626e;

        public h(MetaData metaData) {
            this.f53626e = metaData;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f53626e.getUserId()).param("obj_locate", 1));
            aVar.dismiss();
            if (a.this.f53606a.M2() != null) {
                a.this.f53606a.M2().m(!this.f53626e.hadConcerned(), this.f53626e.getPortrait(), this.f53626e.getUserId(), this.f53626e.isGod(), "6", a.this.f53606a.getPageContext().getUniqueId(), a.this.f53606a.z().getForumId(), "0");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements a.e {
        public i(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f53628e;

        public j(UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            this.f53628e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            a.this.s0();
            MessageManager.getInstance().sendMessage(this.f53628e);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.t != null) {
                d.a.c.e.m.g.a(a.this.t, a.this.f53606a.getPageContext().getPageActivity());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l implements a.e {
        public l(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class m implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f53631e;

        public m(b.c cVar) {
            this.f53631e = cVar;
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            a.this.f53609d.dismiss();
            this.f53631e.a(null, i2, view);
        }
    }

    /* loaded from: classes5.dex */
    public class n implements CompoundButton.OnCheckedChangeListener {
        public n() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                a.this.n = (String) compoundButton.getTag();
                if (a.this.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && a.this.n != null && !str.equals(a.this.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f53612g instanceof Dialog) {
                d.a.c.e.m.g.b(a.this.f53612g, a.this.f53606a.getPageContext());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnLongClickListener {
        public p() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            return a.this.D(view);
        }
    }

    /* loaded from: classes5.dex */
    public class q implements PbFragment.n2 {
        public q() {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.n2
        public void a(Object obj) {
            if (!d.a.c.e.p.j.z()) {
                a.this.f53606a.showToast(R.string.network_not_available);
                return;
            }
            Object[] objArr = (Object[]) obj;
            a.this.f53606a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(a.this.f53606a.getPageContext().getPageActivity(), a.this.f53606a.z().y0().l().getId(), a.this.f53606a.z().y0().l().getName(), a.this.f53606a.z().y0().L().o0(), String.valueOf(a.this.f53606a.z().y0().R().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
        }
    }

    /* loaded from: classes5.dex */
    public class r implements l.e {

        /* renamed from: d.a.k0.d2.o.n.a$r$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C1267a implements a.e {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ SparseArray f53638e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ int f53639f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ boolean f53640g;

            public C1267a(SparseArray sparseArray, int i2, boolean z) {
                this.f53638e = sparseArray;
                this.f53639f = i2;
                this.f53640g = z;
            }

            @Override // d.a.j0.r.s.a.e
            public void onClick(d.a.j0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                a.this.f53606a.G2(((Integer) this.f53638e.get(R.id.tag_del_post_type)).intValue(), (String) this.f53638e.get(R.id.tag_del_post_id), this.f53639f, this.f53640g);
            }
        }

        /* loaded from: classes5.dex */
        public class b implements a.e {
            public b(r rVar) {
            }

            @Override // d.a.j0.r.s.a.e
            public void onClick(d.a.j0.r.s.a aVar) {
                aVar.dismiss();
            }
        }

        public r() {
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            if (a.this.f53607b != null) {
                a.this.f53607b.dismiss();
            }
            a.this.D0(i2);
            int i3 = 4;
            switch (i2) {
                case -4:
                    View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                    a.this.j0(view2);
                    if (view2 != null) {
                        view2.performClick();
                        return;
                    }
                    return;
                case -3:
                    View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                    a.this.j0(view3);
                    if (view3 != null) {
                        view3.performClick();
                        return;
                    }
                    return;
                case -2:
                    View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    AgreeView agreeView = (AgreeView) view4;
                    a.this.j0(view4);
                    if (agreeView == null || agreeView.getImgDisagree() == null) {
                        return;
                    }
                    agreeView.getImgDisagree().performClick();
                    return;
                case -1:
                    View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                    a.this.j0(view5);
                    AgreeView agreeView2 = (AgreeView) view5;
                    if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                        return;
                    }
                    agreeView2.getImgAgree().performClick();
                    return;
                case 0:
                default:
                    return;
                case 1:
                    if (a.this.A == null || TextUtils.isEmpty(a.this.B)) {
                        return;
                    }
                    if (a.this.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, a.this.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f48797a = a.this.B;
                        String str = "";
                        if (a.this.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + a.this.C.memeInfo.pck_id;
                        }
                        aVar.f48798b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                    a.this.A = null;
                    a.this.B = null;
                    return;
                case 2:
                    if (a.this.A == null || TextUtils.isEmpty(a.this.B)) {
                        return;
                    }
                    if (a.this.F == null) {
                        a.this.F = new PermissionJudgePolicy();
                    }
                    a.this.F.clearRequestPermissionList();
                    a.this.F.appendRequestPermission(a.this.f53606a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (a.this.F.startRequestPermission(a.this.f53606a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (a.this.z == null) {
                        a aVar2 = a.this;
                        aVar2.z = new w0(aVar2.f53606a.getPageContext());
                    }
                    a.this.z.b(a.this.B, a.this.A.n());
                    a.this.A = null;
                    a.this.B = null;
                    return;
                case 3:
                    a aVar3 = a.this;
                    PostData postData = aVar3.G;
                    if (postData != null) {
                        postData.h0(aVar3.f53606a.getPageContext().getPageActivity());
                        a.this.G = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                    if (a.this.f53606a.checkUpIsLogin()) {
                        a.this.b0(view);
                        if (a.this.f53606a.z().y0().L() == null || a.this.f53606a.z().y0().L().T() == null || a.this.f53606a.z().y0().L().T().getUserId() == null || a.this.f53606a.X2() == null) {
                            return;
                        }
                        a aVar4 = a.this;
                        int R = aVar4.R(aVar4.f53606a.z().y0());
                        a2 L = a.this.f53606a.z().y0().L();
                        if (L.P1()) {
                            i3 = 2;
                        } else if (L.S1()) {
                            i3 = 3;
                        } else if (!L.Q1()) {
                            i3 = L.R1() ? 5 : 1;
                        }
                        TiebaStatic.log(new StatisticItem("c12526").param("tid", a.this.f53606a.z().O0()).param("obj_locate", 2).param("obj_id", a.this.f53606a.z().y0().L().T().getUserId()).param("obj_type", !a.this.f53606a.X2().e()).param("obj_source", R).param("obj_param1", i3));
                        return;
                    }
                    return;
                case 5:
                    if (!d.a.c.e.p.j.z()) {
                        a.this.f53606a.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new StatisticItem("c13079"));
                        a.this.T((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            a.this.A(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                        if (!((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue()) {
                            d.a.k0.d2.k.e.d1.a.d(a.this.f53606a.getActivity(), a.this.f53606a.getPageContext(), new C1267a(sparseArray3, intValue, booleanValue), new b(this));
                            return;
                        } else {
                            a.this.e0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                            return;
                        }
                    }
                    return;
                case 7:
                    if (!d.a.c.e.p.j.z()) {
                        a.this.f53606a.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 == null) {
                        return;
                    }
                    boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                    boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                    boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                    if (!booleanValue2) {
                        if (booleanValue3) {
                            a.this.e0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        }
                        return;
                    } else if (booleanValue4) {
                        sparseArray4.put(R.id.tag_from, 1);
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        a.this.A(sparseArray4);
                        return;
                    } else {
                        sparseArray4.put(R.id.tag_check_mute_from, 2);
                        a.this.h0(view);
                        return;
                    }
                case 8:
                    if (ViewHelper.checkUpIsLogin(a.this.f53606a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData2.r() == null) {
                            return;
                        }
                        d.a.j0.i0.c f2 = TbPageExtraHelper.f(view);
                        if (f2 != null) {
                            postData2.r().objSource = f2.a();
                        }
                        a.this.B(postData2.r());
                        return;
                    }
                    return;
                case 9:
                    VideoPbFragment videoPbFragment = a.this.f53606a;
                    if (videoPbFragment == null || videoPbFragment.z() == null || a.this.f53606a.z().y0() == null || !ViewHelper.checkUpIsLogin(a.this.f53606a.getContext()) || a.this.f53606a.A() == null) {
                        return;
                    }
                    a.this.f53606a.A().showBlockDialog(d.a.k0.n3.a.b(view));
                    return;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class s implements l.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f53642e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f53643f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f53644g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f53645h;

        public s(SparseArray sparseArray, boolean z, String str, String str2) {
            this.f53642e = sparseArray;
            this.f53643f = z;
            this.f53644g = str;
            this.f53645h = str2;
        }

        @Override // d.a.j0.r.s.l.e
        public void onItemClick(d.a.j0.r.s.l lVar, int i2, View view) {
            if (a.this.f53607b != null) {
                a.this.f53607b.dismiss();
            }
            if (i2 == 0) {
                a.this.e0(((Integer) this.f53642e.get(R.id.tag_del_post_type)).intValue(), (String) this.f53642e.get(R.id.tag_del_post_id), ((Integer) this.f53642e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f53642e.get(R.id.tag_del_post_is_self)).booleanValue());
            } else if (i2 == 1) {
                String str = (String) this.f53642e.get(R.id.tag_user_mute_mute_username);
                String str2 = (String) this.f53642e.get(R.id.tag_user_mute_thread_id);
                String str3 = (String) this.f53642e.get(R.id.tag_user_mute_post_id);
                UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                userMuteAddAndDelCustomMessage.setData(this.f53643f, this.f53644g, str, str2, str3, 1, this.f53645h, a.this.D);
                userMuteAddAndDelCustomMessage.setTag(a.this.D);
                a.this.C0(this.f53643f, userMuteAddAndDelCustomMessage, this.f53645h, str, (String) this.f53642e.get(R.id.tag_user_mute_mute_nameshow));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class t implements a.e {
        public t() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            TiebaStatic.log("c10025");
            aVar.dismiss();
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.f53606a.getFragmentActivity(), 2, true, 4);
            if (!StringUtils.isNULL("4010001001")) {
                memberPayActivityConfig.setSceneId("4010001001");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public class u implements a.e {
        public u(a aVar) {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class v implements b.c {
        public v() {
        }

        @Override // d.a.j0.r.s.b.c
        public void a(d.a.j0.r.s.b bVar, int i2, View view) {
            if (bVar != null) {
                bVar.e();
            }
            if (a.this.A == null || TextUtils.isEmpty(a.this.B)) {
                return;
            }
            if (i2 == 0) {
                if (a.this.C == null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, a.this.B));
                } else {
                    d.a aVar = new d.a();
                    aVar.f48797a = a.this.B;
                    String str = "";
                    if (a.this.C.memeInfo.pck_id.intValue() >= 0) {
                        str = "" + a.this.C.memeInfo.pck_id;
                    }
                    aVar.f48798b = str;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                }
            } else if (i2 == 1) {
                if (a.this.F == null) {
                    a.this.F = new PermissionJudgePolicy();
                }
                a.this.F.clearRequestPermissionList();
                a.this.F.appendRequestPermission(a.this.f53606a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                if (a.this.F.startRequestPermission(a.this.f53606a.getPageContext().getPageActivity())) {
                    return;
                }
                if (a.this.z == null) {
                    a aVar2 = a.this;
                    aVar2.z = new w0(aVar2.f53606a.getPageContext());
                }
                a.this.z.b(a.this.B, a.this.A.n());
            }
            a.this.A = null;
            a.this.B = null;
        }
    }

    /* loaded from: classes5.dex */
    public class w implements a.e {
        public w() {
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            a.this.f53606a.F2(aVar, null);
        }
    }

    public a(VideoPbFragment videoPbFragment) {
        this.f53606a = videoPbFragment;
        this.D = videoPbFragment.getUniqueId();
        d.a.k0.d2.k.f.a aVar = new d.a.k0.d2.k.f.a(this.f53606a.getContext());
        this.x = aVar;
        aVar.a(this.f53606a.getUniqueId());
        this.y = new q();
    }

    public void A(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        s0();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
        userMuteCheckCustomMessage.userIdF = d.a.c.e.m.b.f(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = d.a.c.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        BdUniqueId bdUniqueId = this.D;
        userMuteCheckCustomMessage.mId = bdUniqueId;
        userMuteCheckCustomMessage.setTag(bdUniqueId);
        this.E = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void A0(View view) {
        String[] strArr;
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || videoPbFragment.z() == null) {
            return;
        }
        d.a.j0.r.s.j jVar = new d.a.j0.r.s.j(this.f53606a.getPageContext());
        if (this.f53606a.z().y0().f52719f == null || this.f53606a.z().y0().f52719f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
        } else {
            strArr = new String[this.f53606a.z().y0().f52719f.size()];
            for (int i2 = 0; i2 < this.f53606a.z().y0().f52719f.size(); i2++) {
                strArr[i2] = this.f53606a.z().y0().f52719f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
            }
        }
        jVar.i(null, strArr, new f(jVar, view));
        jVar.l();
    }

    public final void B(AgreeData agreeData) {
        VideoPbFragment videoPbFragment;
        if (agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new d.a.j0.r.b0.a();
        }
        if (this.K == null) {
            d.a.k0.d3.h0.e eVar = new d.a.k0.d3.h0.e();
            this.K = eVar;
            eVar.f53783a = this.f53606a.getUniqueId();
        }
        d.a.j0.r.q.e eVar2 = new d.a.j0.r.q.e();
        eVar2.f49950b = 5;
        eVar2.f49956h = 8;
        eVar2.f49955g = 2;
        VideoPbFragment videoPbFragment2 = this.f53606a;
        if (videoPbFragment2 != null && videoPbFragment2.z() != null) {
            eVar2.f49954f = this.f53606a.z().x0();
        }
        eVar2.f49949a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                eVar2.f49957i = 0;
                this.J.c(agreeData, i2, this.f53606a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                videoPbFragment = this.f53606a;
                if (videoPbFragment != null || videoPbFragment.z() == null || this.f53606a.z().y0() == null) {
                    return;
                }
                this.J.b(this.f53606a.A(), eVar2, agreeData, this.f53606a.z().y0().L());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            eVar2.f49957i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            eVar2.f49957i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.f53606a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        videoPbFragment = this.f53606a;
        if (videoPbFragment != null) {
        }
    }

    public void B0(String str) {
        if (str == null) {
            str = "";
        }
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || videoPbFragment.getPageContext() == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53606a.getPageContext().getPageActivity());
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new i(this));
        aVar.create(this.f53606a.getPageContext()).show();
    }

    public final CustomBlueCheckRadioButton C(String str, String str2) {
        Activity pageActivity = this.f53606a.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.c.e.p.l.g(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public final void C0(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            s0();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53606a.getBaseFragmentActivity());
        if (d.a.c.e.p.k.isEmpty(str)) {
            aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.setMessage(str);
        }
        aVar.setPositiveButton(R.string.confirm, new j(userMuteAddAndDelCustomMessage));
        aVar.setNegativeButton(R.string.cancel, new l(this));
        aVar.create(this.f53606a.getPageContext()).show();
    }

    public final boolean D(View view) {
        SparseArray sparseArray;
        boolean z;
        boolean z2;
        List<d.a.j0.r.s.h> b2;
        d.a.j0.r.s.h hVar;
        d.a.j0.r.s.h hVar2;
        d.a.j0.r.s.h hVar3;
        d.a.j0.r.s.h hVar4;
        d.a.c.j.d.a aVar;
        SparseArray sparseArray2;
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || !videoPbFragment.isAdded()) {
            return true;
        }
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null) {
            if (X(view)) {
                if (view instanceof TbImageView) {
                    TbImageView tbImageView = (TbImageView) view;
                    this.A = tbImageView.getBdImage();
                    String url = tbImageView.getUrl();
                    this.B = url;
                    if (this.A == null || TextUtils.isEmpty(url)) {
                        return true;
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.C = null;
                    }
                } else if (view instanceof GifView) {
                    GifView gifView = (GifView) view;
                    if (gifView.getBdImage() == null) {
                        return true;
                    }
                    this.A = gifView.getBdImage();
                    if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                        this.B = gifView.getBdImage().q();
                    }
                    if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                        this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                    } else {
                        this.C = null;
                    }
                } else if (view instanceof TbMemeImageView) {
                    TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                    if (tbMemeImageView.getBdImage() != null) {
                        this.A = tbMemeImageView.getBdImage();
                        if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                            this.B = tbMemeImageView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.C = null;
                        }
                    }
                }
                if (view.getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                    } catch (ClassCastException e3) {
                        e3.printStackTrace();
                    }
                } else if (view.getParent().getParent() instanceof TbRichTextView) {
                    try {
                        sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                    } catch (ClassCastException e4) {
                        e4.printStackTrace();
                    }
                } else {
                    w0(this.P, this.A.t());
                }
                sparseArray = sparseArray2;
            }
            if (sparseArray == null) {
                return true;
            }
        }
        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
        this.G = postData;
        if (postData == null || this.f53606a.X2() == null) {
            return true;
        }
        boolean z3 = this.f53606a.X2().e() && this.G.E() != null && this.G.E().equals(this.f53606a.z().t0());
        boolean z4 = this.f53606a.z().y0() != null && this.f53606a.z().y0().a0();
        if (this.f53608c == null) {
            d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53606a.getContext());
            this.f53608c = lVar;
            lVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        if (view == null || sparseArray == null) {
            return true;
        }
        boolean z5 = X(view) && !z4;
        boolean z6 = (!X(view) || (aVar = this.A) == null || aVar.t()) ? false : true;
        boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
        boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
        boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
        boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
        boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
        String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
        if (z5) {
            z2 = booleanValue6;
            z = booleanValue5;
            arrayList.add(new d.a.j0.r.s.h(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.f53608c));
        } else {
            z = booleanValue5;
            z2 = booleanValue6;
        }
        if (z6) {
            arrayList.add(new d.a.j0.r.s.h(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.f53608c));
        }
        if (!z5 && !z6) {
            d.a.j0.r.s.h hVar5 = new d.a.j0.r.s.h(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.f53608c);
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_clip_board, this.G);
            hVar5.f50210d.setTag(sparseArray3);
            arrayList.add(hVar5);
        }
        if (!booleanValue && !z4) {
            if (z3) {
                hVar4 = new d.a.j0.r.s.h(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.f53608c);
            } else {
                hVar4 = new d.a.j0.r.s.h(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.f53608c);
            }
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_clip_board, this.G);
            sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
            hVar4.f50210d.setTag(sparseArray4);
            arrayList.add(hVar4);
        }
        if (TbadkCoreApplication.isLogin() && !this.L) {
            if (!W() && !booleanValue4 && booleanValue3) {
                d.a.j0.r.s.h hVar6 = new d.a.j0.r.s.h(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.f53608c);
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                int i2 = R.id.tag_is_mem;
                sparseArray5.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_user_mute_mute_userid;
                sparseArray5.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_user_mute_mute_username;
                sparseArray5.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_user_mute_mute_nameshow;
                sparseArray5.put(i5, sparseArray.get(i5));
                int i6 = R.id.tag_user_mute_post_id;
                sparseArray5.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_user_mute_thread_id;
                sparseArray5.put(i7, sparseArray.get(i7));
                int i8 = R.id.tag_del_post_is_self;
                sparseArray5.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_del_post_type;
                sparseArray5.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_del_post_id;
                sparseArray5.put(i10, sparseArray.get(i10));
                int i11 = R.id.tag_manage_user_identity;
                sparseArray5.put(i11, sparseArray.get(i11));
                hVar6.f50210d.setTag(sparseArray5);
                arrayList.add(hVar6);
            } else {
                if ((Z(booleanValue2) && TbadkCoreApplication.isLogin()) && !z4) {
                    d.a.j0.r.s.h hVar7 = new d.a.j0.r.s.h(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f53608c);
                    hVar7.f50210d.setTag(str);
                    arrayList.add(hVar7);
                }
            }
            if (booleanValue4) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                int i12 = R.id.tag_manage_user_identity;
                sparseArray6.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_forbid_user_name;
                sparseArray6.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_forbid_user_name_show;
                sparseArray6.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_forbid_user_portrait;
                sparseArray6.put(i15, sparseArray.get(i15));
                sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                if (!W() && z) {
                    sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i16 = R.id.tag_is_mem;
                    sparseArray6.put(i16, sparseArray.get(i16));
                    int i17 = R.id.tag_user_mute_mute_userid;
                    sparseArray6.put(i17, sparseArray.get(i17));
                    int i18 = R.id.tag_user_mute_mute_username;
                    sparseArray6.put(i18, sparseArray.get(i18));
                    int i19 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray6.put(i19, sparseArray.get(i19));
                    int i20 = R.id.tag_user_mute_post_id;
                    sparseArray6.put(i20, sparseArray.get(i20));
                    int i21 = R.id.tag_user_mute_thread_id;
                    sparseArray6.put(i21, sparseArray.get(i21));
                } else {
                    sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (z2) {
                    sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i22 = R.id.tag_del_post_id;
                    sparseArray6.put(i22, sparseArray.get(i22));
                    int i23 = R.id.tag_del_post_type;
                    sparseArray6.put(i23, sparseArray.get(i23));
                    int i24 = R.id.tag_has_sub_post;
                    sparseArray6.put(i24, sparseArray.get(i24));
                    hVar2 = new d.a.j0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f53608c);
                    hVar2.f50210d.setTag(sparseArray6);
                } else {
                    sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                    hVar2 = null;
                }
                hVar = new d.a.j0.r.s.h(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.f53608c);
                hVar.f50210d.setTag(sparseArray6);
            } else if (z2) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                int i25 = R.id.tag_manage_user_identity;
                sparseArray7.put(i25, sparseArray.get(i25));
                sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                int i26 = R.id.tag_del_post_id;
                sparseArray7.put(i26, sparseArray.get(i26));
                int i27 = R.id.tag_del_post_type;
                sparseArray7.put(i27, sparseArray.get(i27));
                int i28 = R.id.tag_has_sub_post;
                sparseArray7.put(i28, sparseArray.get(i28));
                if (this.f53606a.z().y0().S() == 1002 && !booleanValue2) {
                    hVar3 = new d.a.j0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f53608c);
                } else {
                    hVar3 = new d.a.j0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f53608c);
                }
                hVar3.f50210d.setTag(sparseArray7);
                hVar2 = hVar3;
                hVar = null;
            } else {
                hVar = null;
                hVar2 = null;
            }
            if (hVar2 != null) {
                arrayList.add(hVar2);
            }
            if (hVar != null) {
                arrayList.add(hVar);
            }
            d.a.k0.d2.k.e.d1.a.a(arrayList, this.f53608c, this.G, this.f53606a.z());
        }
        if (d.a.j0.b.d.z()) {
            b2 = d.a.k0.d2.k.e.d1.a.c(arrayList, this.G.r(), sparseArray, this.f53608c);
        } else {
            b2 = d.a.k0.d2.k.e.d1.a.b(arrayList, this.G.r(), sparseArray, this.f53608c);
        }
        d.a.k0.d2.k.e.d1.a.k(b2, this.O);
        d.a.k0.d2.k.e.d1.a.e(b2);
        this.f53608c.o(d.a.k0.d2.k.e.d1.a.f(this.G));
        if (d.a.j0.b.d.z()) {
            this.f53608c.l(b2, false);
        } else {
            this.f53608c.l(b2, true);
        }
        d.a.j0.r.s.j jVar = new d.a.j0.r.s.j(this.f53606a.getPageContext(), this.f53608c);
        this.f53607b = jVar;
        jVar.l();
        TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f53606a.z().O0()).param("fid", this.f53606a.z().getForumId()).param("uid", this.f53606a.z().y0().L().T().getUserId()).param("post_id", this.f53606a.z().s()).param("obj_source", booleanValue ? 2 : 1));
        return true;
    }

    public final void D0(int i2) {
        TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f53606a.z().O0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.k0.d2.k.e.d1.a.m(i2))));
    }

    public void E() {
        H();
        this.f53606a.k3();
        d.a.j0.r.s.j jVar = this.f53607b;
        if (jVar != null) {
            jVar.dismiss();
        }
        this.f53606a.l3();
        J();
    }

    public final void E0() {
        f0 f0Var = this.u;
        if (f0Var == null) {
            return;
        }
        f0Var.u();
    }

    public void F() {
        H();
        this.f53606a.k3();
        d.a.j0.r.s.j jVar = this.f53607b;
        if (jVar != null) {
            jVar.dismiss();
        }
        J();
    }

    public void G() {
        d.a.j0.r.s.j jVar = this.f53607b;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public void H() {
        if (this.I == null) {
            this.I = new k();
        }
        d.a.c.e.m.e.a().postDelayed(this.I, 100L);
    }

    public void I() {
        AlertDialog alertDialog = this.t;
        if (alertDialog != null) {
            d.a.c.e.m.g.a(alertDialog, this.f53606a.getPageContext().getPageActivity());
        }
    }

    public void J() {
        d.a.j0.r.s.a aVar = this.f53610e;
        if (aVar != null) {
            aVar.dismiss();
        }
        Dialog dialog = this.f53611f;
        if (dialog != null) {
            d.a.c.e.m.g.b(dialog, this.f53606a.getPageContext());
        }
        Dialog dialog2 = this.f53612g;
        if (dialog2 != null) {
            d.a.c.e.m.g.b(dialog2, this.f53606a.getPageContext());
        }
        d.a.j0.r.s.j jVar = this.q;
        if (jVar != null) {
            jVar.dismiss();
        }
    }

    public AntiData K() {
        if (this.f53606a.z() == null || this.f53606a.z().y0() == null) {
            return null;
        }
        return this.f53606a.z().y0().d();
    }

    public View L() {
        View view = this.f53614i;
        if (view != null) {
            return view.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }

    public String M() {
        return this.n;
    }

    public Object N() {
        return this.E;
    }

    public View.OnLongClickListener O() {
        return this.M;
    }

    public f0 P() {
        return this.u;
    }

    public d.a.j0.r.s.b Q() {
        return this.s;
    }

    public int R(d.a.k0.d2.h.e eVar) {
        if (eVar == null || eVar.L() == null) {
            return 0;
        }
        if (eVar.L().t1() == 0) {
            return 1;
        }
        if (eVar.L().t1() == 54) {
            return 2;
        }
        return eVar.L().t1() == 40 ? 3 : 4;
    }

    public void S(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
        String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
        String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
        String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
        String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.D);
        userMuteAddAndDelCustomMessage.setTag(this.D);
        C0(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void T(String str) {
        if (this.f53606a.z() != null && this.f53606a.z().y0() != null && this.f53606a.z().y0().a0()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.f53606a.z().O0(), str);
            a2 L = this.f53606a.z().y0().L();
            if (L.P1()) {
                format = format + "&channelid=33833";
            } else if (L.U1()) {
                format = format + "&channelid=33842";
            } else if (L.S1()) {
                format = format + "&channelid=33840";
            }
            a0(format);
            return;
        }
        this.x.i(str);
    }

    public void U() {
        d.a.j0.r.f0.a aVar = this.r;
        if (aVar != null) {
            aVar.h(false);
        }
    }

    public void V() {
        if (this.s != null) {
            return;
        }
        this.s = new d.a.j0.r.s.b(this.f53606a.getPageContext().getPageActivity());
        String[] strArr = {this.f53606a.getPageContext().getString(R.string.call_phone), this.f53606a.getPageContext().getString(R.string.sms_phone), this.f53606a.getPageContext().getString(R.string.search_in_baidu)};
        d.a.j0.r.s.b bVar = this.s;
        bVar.j(strArr, new e());
        bVar.g(b.C1138b.f50180a);
        bVar.h(17);
        bVar.c(this.f53606a.getPageContext());
    }

    public boolean W() {
        return d.a.k0.d2.k.e.d1.a.h(this.f53606a.z());
    }

    public boolean X(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public boolean Y(int i2) {
        List<ForumToolPerm> forumToolAuth;
        if (i2 != 1) {
            if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f53606a.z().y0().R() != null && (forumToolAuth = this.f53606a.z().y0().R().getForumToolAuth()) != null) {
                for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                    ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                    if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean Z(boolean z) {
        if (this.f53606a.z() != null && this.f53606a.z().y0() != null) {
            return ((this.f53606a.z().y0().S() != 0) || this.f53606a.z().y0().L() == null || this.f53606a.z().y0().L().T() == null || TextUtils.equals(this.f53606a.z().y0().L().T().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
        }
        return false;
    }

    public final void a0(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f53606a.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
    }

    public final void b0(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e2) {
            e2.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        c0(postData);
    }

    public void c0(PostData postData) {
        if (postData == null) {
            return;
        }
        boolean z = false;
        if (postData.E() != null && postData.E().equals(this.f53606a.z().t0())) {
            z = true;
        }
        MarkData s0 = this.f53606a.z().s0(postData);
        if (this.f53606a.z().y0() != null && this.f53606a.z().y0().a0()) {
            VideoPbFragment videoPbFragment = this.f53606a;
            PostData R2 = videoPbFragment.R2(videoPbFragment.z().y0());
            if (R2 != null) {
                s0 = this.f53606a.z().s0(R2);
            }
        }
        if (s0 == null) {
            return;
        }
        this.f53606a.w4();
        if (this.f53606a.X2() != null) {
            this.f53606a.X2().i(s0);
            if (!z) {
                this.f53606a.X2().a();
            } else {
                this.f53606a.X2().d();
            }
        }
    }

    public void d0(ArrayList<l0> arrayList) {
        if (this.f53614i == null) {
            this.f53614i = LayoutInflater.from(this.f53606a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.f53606a.getBaseFragmentActivity().getLayoutMode().j(this.f53614i);
        if (this.f53612g == null) {
            Dialog dialog = new Dialog(this.f53606a.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.f53612g = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.f53612g.setCancelable(true);
            this.o = (ScrollView) this.f53614i.findViewById(R.id.good_scroll);
            this.f53612g.setContentView(this.f53614i);
            WindowManager.LayoutParams attributes = this.f53612g.getWindow().getAttributes();
            attributes.width = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.f53612g.getWindow().setAttributes(attributes);
            this.p = new n();
            this.j = (LinearLayout) this.f53614i.findViewById(R.id.good_class_group);
            TextView textView = (TextView) this.f53614i.findViewById(R.id.dialog_button_cancel);
            this.l = textView;
            textView.setOnClickListener(new o());
            TextView textView2 = (TextView) this.f53614i.findViewById(R.id.dialog_button_ok);
            this.k = textView2;
            textView2.setOnClickListener(this.f53606a.U2());
        }
        this.j.removeAllViews();
        this.m = new ArrayList();
        CustomBlueCheckRadioButton C = C("0", this.f53606a.getPageContext().getString(R.string.thread_good_class));
        this.m.add(C);
        C.setChecked(true);
        this.j.addView(C);
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                l0 l0Var = arrayList.get(i2);
                if (l0Var != null && !TextUtils.isEmpty(l0Var.b()) && l0Var.a() > 0) {
                    CustomBlueCheckRadioButton C2 = C(String.valueOf(l0Var.a()), l0Var.b());
                    this.m.add(C2);
                    View view = new View(this.f53606a.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                    view.setLayoutParams(layoutParams);
                    this.j.addView(view);
                    this.j.addView(C2);
                }
            }
            ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
            int size = arrayList.size();
            if (size == 0 || size == 1) {
                layoutParams2.height = d.a.c.e.p.l.e(this.f53606a.getPageContext().getPageActivity(), 120.0f);
            } else if (size != 2) {
                layoutParams2.height = d.a.c.e.p.l.e(this.f53606a.getPageContext().getPageActivity(), 220.0f);
            } else {
                layoutParams2.height = d.a.c.e.p.l.e(this.f53606a.getPageContext().getPageActivity(), 186.0f);
            }
            this.o.setLayoutParams(layoutParams2);
            this.o.removeAllViews();
            LinearLayout linearLayout = this.j;
            if (linearLayout != null && linearLayout.getParent() == null) {
                this.o.addView(this.j);
            }
        }
        d.a.c.e.m.g.j(this.f53612g, this.f53606a.getPageContext());
    }

    public void e0(int i2, String str, int i3, boolean z) {
        f0(i2, str, i3, z, null);
    }

    public void f0(int i2, String str, int i3, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(Q, Integer.valueOf(R));
        int i4 = R.string.del_all_post_confirm;
        if (i3 == 1002 && !z) {
            i4 = R.string.report_post_confirm;
        }
        if (i2 == 0) {
            if (i3 == 1002 && !z) {
                i4 = R.string.report_thread_confirm;
            } else {
                i4 = R.string.del_thread_confirm;
            }
        }
        this.f53610e = new d.a.j0.r.s.a(this.f53606a.getActivity());
        if (StringUtils.isNull(str2)) {
            this.f53610e.setMessageId(i4);
        } else {
            this.f53610e.setOnlyMessageShowCenter(false);
            this.f53610e.setMessage(str2);
        }
        this.f53610e.setYesButtonTag(sparseArray);
        this.f53610e.setPositiveButton(R.string.dialog_ok, new w());
        this.f53610e.setNegativeButton(R.string.dialog_cancel, new C1266a(this));
        this.f53610e.setCancelable(true);
        this.f53610e.create(this.f53606a.getPageContext());
        if (z) {
            this.f53610e.show();
        } else if (m0()) {
            d.a.k0.h.h hVar = new d.a.k0.h.h(this.f53606a.z().y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f53606a.z().y0().l().getDeletedReasonInfo().is_boomgrow.intValue(), this.f53606a.z().y0().o().has_forum_rule.intValue());
            hVar.i(this.f53606a.z().y0().l().getId(), this.f53606a.z().y0().l().getName());
            hVar.h(this.f53606a.z().y0().l().getImage_url());
            hVar.j(this.f53606a.z().y0().l().getUser_level());
            t0(this.f53610e, i2, hVar, this.f53606a.z().y0().R());
        } else {
            z0(this.f53610e, i2);
        }
    }

    public void g0(SparseArray<Object> sparseArray, boolean z) {
        d.a.j0.r.s.h hVar;
        d.a.j0.r.s.h hVar2;
        d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53606a.getContext());
        lVar.q(this.f53606a.getString(R.string.bar_manager));
        lVar.n(new d(z));
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                hVar2 = new d.a.j0.r.s.h(10, this.f53606a.getString(R.string.delete_post), lVar);
            } else {
                hVar2 = new d.a.j0.r.s.h(10, this.f53606a.getString(R.string.delete), lVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            int i2 = R.id.tag_del_post_id;
            sparseArray2.put(i2, sparseArray.get(i2));
            int i3 = R.id.tag_del_post_type;
            sparseArray2.put(i3, sparseArray.get(i3));
            int i4 = R.id.tag_del_post_is_self;
            sparseArray2.put(i4, sparseArray.get(i4));
            int i5 = R.id.tag_manage_user_identity;
            sparseArray2.put(i5, sparseArray.get(i5));
            hVar2.f50210d.setTag(sparseArray2);
            arrayList.add(hVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            int i6 = R.id.tag_forbid_user_name;
            sparseArray3.put(i6, sparseArray.get(i6));
            int i7 = R.id.tag_forbid_user_name_show;
            sparseArray3.put(i7, sparseArray.get(i7));
            int i8 = R.id.tag_forbid_user_portrait;
            sparseArray3.put(i8, sparseArray.get(i8));
            int i9 = R.id.tag_manage_user_identity;
            sparseArray3.put(i9, sparseArray.get(i9));
            int i10 = R.id.tag_forbid_user_post_id;
            sparseArray3.put(i10, sparseArray.get(i10));
            d.a.j0.r.s.h hVar3 = new d.a.j0.r.s.h(11, this.f53606a.getString(R.string.forbidden_person), lVar);
            hVar3.f50210d.setTag(sparseArray3);
            arrayList.add(hVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            int i11 = R.id.tag_is_mem;
            sparseArray4.put(i11, sparseArray.get(i11));
            int i12 = R.id.tag_user_mute_mute_userid;
            sparseArray4.put(i12, sparseArray.get(i12));
            int i13 = R.id.tag_user_mute_mute_username;
            sparseArray4.put(i13, sparseArray.get(i13));
            int i14 = R.id.tag_user_mute_mute_nameshow;
            sparseArray4.put(i14, sparseArray.get(i14));
            int i15 = R.id.tag_user_mute_post_id;
            sparseArray4.put(i15, sparseArray.get(i15));
            int i16 = R.id.tag_user_mute_thread_id;
            sparseArray4.put(i16, sparseArray.get(i16));
            int i17 = R.id.tag_user_mute_msg;
            sparseArray4.put(i17, sparseArray.get(i17));
            if (z) {
                hVar = new d.a.j0.r.s.h(12, this.f53606a.getString(R.string.un_mute), lVar);
            } else {
                hVar = new d.a.j0.r.s.h(12, this.f53606a.getString(R.string.mute), lVar);
            }
            hVar.f50210d.setTag(sparseArray4);
            arrayList.add(hVar);
        }
        lVar.k(arrayList);
        d.a.j0.r.s.j jVar = this.q;
        if (jVar == null) {
            this.q = new d.a.j0.r.s.j(this.f53606a.getPageContext(), lVar);
        } else {
            jVar.h(lVar);
        }
        this.q.l();
    }

    public void h0(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            return;
        }
        g0(sparseArray, false);
    }

    public void i0() {
        d.a.k0.d2.h.e y0;
        a2 L;
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || videoPbFragment.z() == null || this.f53606a.z().y0() == null || (L = (y0 = this.f53606a.z().y0()).L()) == null || L.T() == null) {
            return;
        }
        this.f53606a.k3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), L.T().getUserId());
        g0 g0Var = new g0();
        int S = this.f53606a.z().y0().S();
        boolean z = false;
        if (S != 1 && S != 3) {
            g0Var.f53086g = false;
        } else {
            g0Var.f53086g = true;
            g0Var.p = L.x0() == 1;
        }
        if (Y(S)) {
            g0Var.f53087h = true;
            g0Var.o = L.w0() == 1;
        } else {
            g0Var.f53087h = false;
        }
        if (S == 1002 && !equals) {
            g0Var.q = true;
        }
        g0Var.f53084e = n0(equals);
        g0Var.f53088i = q0();
        g0Var.f53085f = p0(equals);
        g0Var.k = equals && y0.R() != null && y0.R().showPbPrivate();
        g0Var.n = this.f53606a.z().M0();
        g0Var.f53081b = true;
        g0Var.f53080a = Z(equals);
        g0Var.m = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.l = this.f53606a.z().d0();
        g0Var.f53083d = true;
        if (L.v1() == null) {
            g0Var.f53082c = true;
        } else {
            g0Var.f53082c = false;
        }
        if (y0.a0()) {
            g0Var.f53081b = false;
            g0Var.f53083d = false;
            g0Var.f53082c = false;
            g0Var.f53086g = false;
            g0Var.f53087h = false;
        }
        if (TbSingleton.getInstance().mShowCallFans && equals && !y0.a0()) {
            z = true;
        }
        g0Var.r = z;
        VideoPbFragment videoPbFragment2 = this.f53606a;
        if (videoPbFragment2.R2(videoPbFragment2.z().y0()) != null) {
            VideoPbFragment videoPbFragment3 = this.f53606a;
            g0Var.s = videoPbFragment3.R2(videoPbFragment3.z().y0()).S;
        }
        y0(g0Var);
    }

    public final void j0(View view) {
        if (view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.O ? 2 : 3));
        view.setTag(sparseArray);
    }

    public void k0(boolean z) {
        this.O = z;
    }

    public void l0(String str) {
        this.H = str;
    }

    public final boolean m0() {
        VideoPbFragment videoPbFragment = this.f53606a;
        return (videoPbFragment == null || videoPbFragment.z().y0().l().getDeletedReasonInfo() == null || 1 != this.f53606a.z().y0().l().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
    }

    public final boolean n0(boolean z) {
        d0 d0Var;
        int i2;
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || videoPbFragment.z() == null || this.f53606a.z().y0() == null) {
            return false;
        }
        d.a.k0.d2.h.e y0 = this.f53606a.z().y0();
        a2 L = y0.L();
        if (L != null) {
            if (L.P1() || L.S1()) {
                return false;
            }
            if (L.Q1() || L.R1()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (L == null || L.T() == null || !L.T().isForumBusinessAccount() || d.a.k0.q0.w0.isOn()) {
            if (y0.l() == null || !y0.l().isBlockBawuDelete) {
                if (y0.S() != 0) {
                    return y0.S() != 3;
                }
                List<w1> p2 = y0.p();
                if (ListUtils.getCount(p2) > 0) {
                    for (w1 w1Var : p2) {
                        if (w1Var != null && (d0Var = w1Var.f50119g) != null && d0Var.f49944a && !d0Var.f49946c && ((i2 = d0Var.f49945b) == 1 || i2 == 2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void o0(SparseArray<Object> sparseArray) {
        PostData postData;
        d.a.j0.r.s.h hVar;
        d.a.j0.r.s.h hVar2;
        d.a.j0.r.s.h hVar3;
        VideoPbFragment videoPbFragment;
        int i2;
        VideoPbFragment videoPbFragment2 = this.f53606a;
        if (videoPbFragment2 == null || videoPbFragment2.z() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.f53608c == null) {
            d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53606a.getContext());
            this.f53608c = lVar;
            lVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.f53606a.z().y0() != null && this.f53606a.z().y0().a0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (postData.r() != null) {
                boolean z2 = postData.r().hasAgree;
                int s2 = postData.s();
                if (z2 && s2 == 5) {
                    videoPbFragment = this.f53606a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    videoPbFragment = this.f53606a;
                    i2 = R.string.action_dislike;
                }
                d.a.j0.r.s.h hVar4 = new d.a.j0.r.s.h(8, videoPbFragment.getString(i2), this.f53608c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                hVar4.f50210d.setTag(sparseArray2);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    d.a.j0.r.s.h hVar5 = new d.a.j0.r.s.h(5, this.f53606a.getString(R.string.mute_option), this.f53608c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = R.id.tag_is_mem;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_userid;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_username;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_post_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_user_mute_thread_id;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_is_self;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_type;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_del_post_id;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray3.put(i12, sparseArray.get(i12));
                    hVar5.f50210d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                } else {
                    if ((Z(booleanValue) && TbadkCoreApplication.isLogin()) && !z) {
                        d.a.j0.r.s.h hVar6 = new d.a.j0.r.s.h(5, this.f53606a.getString(R.string.report_text), this.f53608c);
                        hVar6.f50210d.setTag(str);
                        arrayList.add(hVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = R.id.tag_manage_user_identity;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_name_show;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = R.id.tag_forbid_user_portrait;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = R.id.tag_is_mem;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_userid;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_username;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_post_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                        int i22 = R.id.tag_user_mute_thread_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                        int i23 = R.id.tag_del_post_id;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_del_post_type;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        int i25 = R.id.tag_has_sub_post;
                        sparseArray4.put(i25, sparseArray.get(i25));
                        hVar2 = new d.a.j0.r.s.h(6, this.f53606a.getString(R.string.delete), this.f53608c);
                        hVar2.f50210d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.j0.r.s.h(7, this.f53606a.getString(R.string.bar_manager), this.f53608c);
                    hVar.f50210d.setTag(sparseArray4);
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                    int i27 = R.id.tag_del_post_id;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_del_post_type;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    int i29 = R.id.tag_has_sub_post;
                    sparseArray5.put(i29, sparseArray.get(i29));
                    if (this.f53606a.z().y0().S() == 1002 && !booleanValue) {
                        hVar3 = new d.a.j0.r.s.h(6, this.f53606a.getString(R.string.report_text), this.f53608c);
                    } else {
                        hVar3 = new d.a.j0.r.s.h(6, this.f53606a.getString(R.string.delete), this.f53608c);
                    }
                    hVar3.f50210d.setTag(sparseArray5);
                    hVar2 = hVar3;
                    hVar = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                if (!booleanValue) {
                    arrayList.add(new d.a.j0.r.s.h(9, TbadkCoreApplication.getInst().getString(R.string.block_user), this.f53608c));
                }
            }
            this.f53608c.k(arrayList);
            d.a.j0.r.s.j jVar = new d.a.j0.r.s.j(this.f53606a.getPageContext(), this.f53608c);
            this.f53607b = jVar;
            jVar.l();
        }
    }

    public final boolean p0(boolean z) {
        VideoPbFragment videoPbFragment;
        if (z || (videoPbFragment = this.f53606a) == null || videoPbFragment.z() == null || this.f53606a.z().y0() == null || (this.f53606a.z().y0().l() != null && this.f53606a.z().y0().l().isBlockBawuDelete)) {
            return false;
        }
        d.a.k0.d2.h.e y0 = this.f53606a.z().y0();
        return ((y0.L() != null && y0.L().T() != null && y0.L().T().isForumBusinessAccount() && !d.a.k0.q0.w0.isOn()) || this.f53606a.z().y0().S() == 0 || this.f53606a.z().y0().S() == 3) ? false : true;
    }

    public final boolean q0() {
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || videoPbFragment.z() == null || !this.f53606a.z().M0()) {
            return false;
        }
        return this.f53606a.z().w0() == null || this.f53606a.z().w0().c() != 0;
    }

    public void r0(MetaData metaData) {
        if (metaData == null) {
            return;
        }
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53606a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new g(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new h(metaData));
        aVar.create(this.f53606a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void s0() {
        if (this.r == null) {
            this.r = new d.a.j0.r.f0.a(this.f53606a.getPageContext());
        }
        this.r.h(true);
    }

    public final void t0(d.a.j0.r.s.a aVar, int i2, d.a.k0.h.h hVar, UserData userData) {
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || aVar == null) {
            return;
        }
        if (this.w == null && videoPbFragment.getView() != null) {
            this.w = new d.a.k0.h.i(this.f53606a.getPageContext(), this.f53606a.getView(), hVar, userData);
        }
        AntiData K = K();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (K != null && K.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = K.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        this.w.B(new String[]{this.f53606a.getString(R.string.delete_thread_reason_1), this.f53606a.getString(R.string.delete_thread_reason_2), this.f53606a.getString(R.string.delete_thread_reason_3), this.f53606a.getString(R.string.delete_thread_reason_4), this.f53606a.getString(R.string.delete_thread_reason_5)});
        this.w.A(v0Var);
        this.w.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.C(new c(aVar));
    }

    public void u0() {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f53606a.getPageContext().getPageActivity());
        aVar.setMessage(this.f53606a.getResources().getString(R.string.mute_is_super_member_function));
        aVar.setPositiveButton(R.string.open_now, new t());
        aVar.setNegativeButton(R.string.cancel, new u(this));
        aVar.create(this.f53606a.getPageContext()).show();
    }

    public void v0(boolean z, SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.j0.r.s.j jVar = this.f53607b;
            if (jVar != null && jVar.isShowing()) {
                this.f53607b.dismiss();
                this.f53607b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53606a.getBaseFragmentActivity());
                lVar.n(new s(sparseArray, z, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.j0.r.s.h(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), lVar));
                }
                if (z) {
                    arrayList.add(new d.a.j0.r.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.j0.r.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.j0.r.s.j jVar2 = new d.a.j0.r.s.j(this.f53606a.getPageContext(), lVar);
                this.f53607b = jVar2;
                jVar2.l();
            }
        }
    }

    public void w0(b.c cVar, boolean z) {
        d.a.j0.r.s.j jVar = this.f53609d;
        if (jVar != null) {
            jVar.dismiss();
            this.f53609d = null;
        }
        d.a.j0.r.s.l lVar = new d.a.j0.r.s.l(this.f53606a.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.f53606a.z().y0() != null && this.f53606a.z().y0().L() != null && !this.f53606a.z().y0().L().T1()) {
            arrayList.add(new d.a.j0.r.s.h(0, this.f53606a.getPageContext().getString(R.string.save_to_emotion), lVar));
        }
        if (!z) {
            arrayList.add(new d.a.j0.r.s.h(1, this.f53606a.getPageContext().getString(R.string.save_to_local), lVar));
        }
        lVar.k(arrayList);
        lVar.n(new m(cVar));
        d.a.j0.r.s.j jVar2 = new d.a.j0.r.s.j(this.f53606a.getPageContext(), lVar);
        this.f53609d = jVar2;
        jVar2.l();
    }

    public void x0(AdapterView.OnItemClickListener onItemClickListener) {
        d.a.j0.r.s.e eVar = this.f53613h;
        if (eVar != null) {
            eVar.d();
            this.f53613h = null;
        }
        if (this.f53606a.z() == null) {
            return;
        }
        ArrayList<d.a.j0.r.s.n> arrayList = new ArrayList<>();
        arrayList.add(new d.a.j0.r.s.n(this.f53606a.getContext().getString(R.string.all_person), "", this.f53606a.z().H0() == 1, Integer.toString(1)));
        arrayList.add(new d.a.j0.r.s.n(this.f53606a.getContext().getString(R.string.my_fans), "", this.f53606a.z().H0() == 2, Integer.toString(5)));
        arrayList.add(new d.a.j0.r.s.n(this.f53606a.getContext().getString(R.string.my_attentions), "", this.f53606a.z().H0() == 3, Integer.toString(6)));
        arrayList.add(new d.a.j0.r.s.n(this.f53606a.getContext().getString(R.string.myself_only), "", this.f53606a.z().H0() == 4, Integer.toString(7)));
        d.a.j0.r.s.e eVar2 = new d.a.j0.r.s.e(this.f53606a.getPageContext());
        eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
        this.f53613h = eVar2;
        eVar2.k(arrayList, onItemClickListener);
        eVar2.c();
        this.f53613h.n();
    }

    public void y0(g0 g0Var) {
        if (this.f53606a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        VideoPbFragment videoPbFragment = this.f53606a;
        this.u = new f0(videoPbFragment, videoPbFragment.G1);
        AlertDialog create = new AlertDialog.Builder(this.f53606a.getContext(), R.style.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        d.a.c.e.m.g.i(this.t, this.f53606a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.r());
        this.u.I(g0Var == null ? false : g0Var.f53080a);
        this.u.w(g0Var == null ? false : g0Var.f53084e);
        this.u.A(g0Var == null ? false : g0Var.f53088i);
        this.u.x(g0Var == null ? false : g0Var.f53085f);
        this.u.K(g0Var != null ? g0Var.f53082c : true);
        this.u.H(g0Var == null ? false : g0Var.k);
        if (g0Var == null) {
            this.u.F(false, false);
            this.u.B(false, false);
        } else {
            this.u.F(g0Var.f53086g, g0Var.p);
            this.u.B(g0Var.f53087h, g0Var.o);
        }
        boolean z = g0Var == null ? false : g0Var.n;
        boolean z2 = g0Var == null ? false : g0Var.l;
        boolean z3 = g0Var == null ? false : g0Var.f53083d;
        boolean z4 = g0Var == null ? false : g0Var.f53081b;
        boolean z5 = g0Var == null ? false : g0Var.m;
        boolean z6 = g0Var == null ? false : g0Var.j;
        this.u.y(z3, z2);
        this.u.J(z4, z);
        this.u.G(z6, z5);
        if (g0Var != null) {
            f0 f0Var = this.u;
            boolean z7 = g0Var.q;
            f0Var.u = z7;
            if (z7) {
                f0Var.f().setText(R.string.report_text);
                this.u.x(false);
            }
        }
        this.u.v(g0Var != null ? g0Var.r : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f53606a.z() != null && this.f53606a.z().y0() != null && this.f53606a.z().y0().N() != null && this.f53606a.z().y0().N().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(R.string.have_called_fans_short);
        }
        E0();
    }

    public final void z0(d.a.j0.r.s.a aVar, int i2) {
        VideoPbFragment videoPbFragment = this.f53606a;
        if (videoPbFragment == null || aVar == null) {
            return;
        }
        if (this.v == null && videoPbFragment.getView() != null) {
            this.v = new d.a.k0.h.f(this.f53606a.getPageContext(), this.f53606a.getView());
        }
        AntiData K = K();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (K != null && K.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = K.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        v0 v0Var = new v0();
        v0Var.j(sparseArray);
        this.v.x(new String[]{this.f53606a.getString(R.string.delete_thread_reason_1), this.f53606a.getString(R.string.delete_thread_reason_2), this.f53606a.getString(R.string.delete_thread_reason_3), this.f53606a.getString(R.string.delete_thread_reason_4), this.f53606a.getString(R.string.delete_thread_reason_5)});
        this.v.w(v0Var);
        this.v.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.y(new b(aVar));
    }
}
