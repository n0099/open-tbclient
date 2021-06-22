package d.a.o0.r0;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.svg.AbsSvgType;
import com.baidu.tbadk.core.util.svg.SvgMaskType;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
/* loaded from: classes4.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63670a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f63671b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63672c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63673d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63674e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63675f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f63676g;

    /* renamed from: h  reason: collision with root package name */
    public PermissionJudgePolicy f63677h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.o0.e2.k.e.x0 f63678i;
    public Bitmap j;
    public e k;
    public View l;
    public String m;
    public String n;
    public d o;
    public int p;
    public View.OnClickListener q = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Bitmap m = z.this.m();
            if (view.getId() == z.this.f63671b.getId()) {
                z.this.p(m);
            } else if (view.getId() == z.this.f63672c.getId()) {
                z.this.u(m, 3);
            } else if (view.getId() == z.this.f63673d.getId()) {
                z.this.u(m, 2);
            } else if (view.getId() == z.this.f63674e.getId()) {
                z.this.u(m, 4);
            } else if (view.getId() == z.this.f63675f.getId()) {
                z.this.u(m, 8);
            } else if (view.getId() == z.this.f63676g.getId()) {
                z.this.u(m, 6);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.n0.z0.f0<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f63680a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f63681b;

        public b(Bitmap bitmap, int i2) {
            this.f63680a = bitmap;
            this.f63681b = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.f0
        /* renamed from: a */
        public ShareItem doInBackground() {
            return z.this.l(this.f63680a, this.f63681b);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements d.a.n0.z0.n<ShareItem> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f63683a;

        public c(int i2) {
            this.f63683a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.n0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            MessageManager.getInstance().sendMessage(new ImplicitShareMessage(z.this.f63670a.getPageActivity(), this.f63683a, shareItem, false));
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2);
    }

    public z(TbPageContext tbPageContext) {
        this.f63670a = tbPageContext;
    }

    public final boolean k() {
        if (this.f63677h == null) {
            this.f63677h = new PermissionJudgePolicy();
        }
        this.f63677h.clearRequestPermissionList();
        this.f63677h.appendRequestPermission(this.f63670a.getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        return this.f63677h.startRequestPermission(this.f63670a.getPageActivity());
    }

    public final ShareItem l(Bitmap bitmap, int i2) {
        ShareItem shareItem = new ShareItem();
        shareItem.c0 = false;
        shareItem.b0 = false;
        shareItem.W = 1;
        if (i2 == 6) {
            shareItem.r = this.f63670a.getString(R.string.come_on_look_forum) + PreferencesUtil.LEFT_MOUNT + this.n + this.f63670a.getString(R.string.core_bar) + PreferencesUtil.RIGHT_MOUNT + "@" + this.f63670a.getString(R.string.tieba_text) + "https://tieba.baidu.com/f?kw=" + d.a.c.e.p.k.getUrlEncode(this.n) + "&fr=frsshare";
        } else {
            shareItem.r = this.f63670a.getString(R.string.app_name);
        }
        shareItem.s = "";
        shareItem.i(bitmap);
        shareItem.g();
        return shareItem;
    }

    public Bitmap m() {
        if (this.j == null) {
            d dVar = this.o;
            if (dVar != null) {
                dVar.a();
            }
            this.l.buildDrawingCache();
            this.j = this.l.getDrawingCache();
            d dVar2 = this.o;
            if (dVar2 != null) {
                dVar2.b();
            }
        }
        return this.j;
    }

    public final int n() {
        int k;
        int g2 = d.a.c.e.p.l.g(this.f63670a.getPageActivity(), R.dimen.tbds44);
        int g3 = d.a.c.e.p.l.g(this.f63670a.getPageActivity(), R.dimen.tbds54);
        if (UtilHelper.getRealScreenOrientation(this.f63670a.getPageActivity()) == 2) {
            k = d.a.c.e.p.l.i(this.f63670a.getPageActivity());
        } else {
            k = d.a.c.e.p.l.k(this.f63670a.getPageActivity());
        }
        return ((k - (g2 * 2)) - g3) / 6;
    }

    public void o(View view, View view2, d dVar) {
        if (view == null) {
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.frs_private_share_download);
        this.f63671b = textView;
        t(textView, new SvgMaskType(R.drawable.icon_mask_frs_private_share_download40_svg));
        this.f63671b.setOnClickListener(this.q);
        TextView textView2 = (TextView) view.findViewById(R.id.frs_private_share_wechat);
        this.f63672c = textView2;
        t(textView2, new SvgMaskType(R.drawable.icon_mask_share_wechat40_svg));
        this.f63672c.setOnClickListener(this.q);
        TextView textView3 = (TextView) view.findViewById(R.id.frs_private_share_moment);
        this.f63673d = textView3;
        t(textView3, new SvgMaskType(R.drawable.icon_mask_share_circle40_svg));
        this.f63673d.setOnClickListener(this.q);
        TextView textView4 = (TextView) view.findViewById(R.id.frs_private_share_qzone);
        this.f63674e = textView4;
        t(textView4, new SvgMaskType(R.drawable.icon_mask_share_qqzone40_svg));
        this.f63674e.setOnClickListener(this.q);
        TextView textView5 = (TextView) view.findViewById(R.id.frs_private_share_qq);
        this.f63675f = textView5;
        t(textView5, new SvgMaskType(R.drawable.icon_mask_share_qq40_svg));
        this.f63675f.setOnClickListener(this.q);
        TextView textView6 = (TextView) view.findViewById(R.id.frs_private_share_weibo);
        this.f63676g = textView6;
        t(textView6, new SvgMaskType(R.drawable.icon_mask_share_weibo40_svg));
        this.f63676g.setOnClickListener(this.q);
        this.l = view2;
        this.o = dVar;
    }

    public final void p(Bitmap bitmap) {
        if (k()) {
            return;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(1);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        if (this.f63678i == null) {
            this.f63678i = new d.a.o0.e2.k.e.x0(this.f63670a);
        }
        this.f63678i.b(this.m, BitmapHelper.Bitmap2Bytes(bitmap, 100));
    }

    public void q(String str, String str2) {
        this.m = str;
        this.n = str2;
    }

    public void r(int i2) {
        this.p = i2;
    }

    public void s(e eVar) {
        this.k = eVar;
    }

    public final void t(TextView textView, AbsSvgType absSvgType) {
        Drawable drawable;
        if (absSvgType == null || (drawable = absSvgType.getDrawable()) == null) {
            return;
        }
        int g2 = d.a.c.e.p.l.g(this.f63670a.getPageActivity(), R.dimen.tbds88);
        drawable.setBounds(0, 0, g2, g2);
        textView.setCompoundDrawables(null, drawable, null, null);
        SkinManager.setViewTextColor(textView, R.color.CAM_X0106);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = n();
        textView.setLayoutParams(layoutParams);
    }

    public final void u(Bitmap bitmap, int i2) {
        if (bitmap == null || k()) {
            return;
        }
        int i3 = 1;
        if (i2 == 3) {
            i3 = 2;
        } else if (i2 == 2) {
            i3 = 3;
        } else if (i2 == 4) {
            i3 = 4;
        } else if (i2 == 8) {
            i3 = 5;
        } else if (i2 == 6) {
            i3 = 6;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.a(i3);
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.THREAD_ACHIEVEMENT_DETAIL_SHARE);
        if (i2 == 3) {
            statisticItem.param("obj_type", 2);
        } else if (i2 == 2) {
            statisticItem.param("obj_type", 3);
        } else if (i2 == 8) {
            statisticItem.param("obj_type", 4);
        } else if (i2 == 4) {
            statisticItem.param("obj_type", 5);
        } else if (i2 == 6) {
            statisticItem.param("obj_type", 6);
        }
        statisticItem.param("obj_source", this.p);
        TiebaStatic.log(statisticItem);
        d.a.n0.z0.h0.b(new b(bitmap, i2), new c(i2));
    }
}
