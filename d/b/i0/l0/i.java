package d.b.i0.l0;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.gif.GifInfo;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.FacePackageData;
import com.baidu.tieba.faceshop.FacePackageDetailActivity;
import com.baidu.tieba.faceshop.FacePackageDetailModel;
import com.baidu.tieba.faceshop.QueryDownloadMessage;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.LinkedList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class i {
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public final ScrollView E;
    public int F;
    public final TbImageView H;
    public int I;
    public int J;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePackageDetailActivity> f56529a;

    /* renamed from: b  reason: collision with root package name */
    public final View f56530b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f56531c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f56532d;

    /* renamed from: e  reason: collision with root package name */
    public final TbImageView f56533e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f56534f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f56535g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f56536h;
    public final TextView i;
    public final TextView j;
    public final TextView k;
    public final FrameLayout l;
    public final ImageView m;
    public final ImageView n;
    public final LinearLayout o;
    public TextView p;
    public final int q;
    public final int r;
    public final int s;
    public final GridView t;
    public j u;
    public final Handler v;
    public final h w;
    public GifView x;
    public WindowManager y;
    public WindowManager.LayoutParams z;
    public int G = -1;
    public final Runnable K = new b();

    /* loaded from: classes4.dex */
    public class a implements AdapterView.OnItemClickListener {
        public a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            i.this.t.setSelection(-1);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                i.this.k();
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public i(TbPageContext<FacePackageDetailActivity> tbPageContext) {
        this.f56529a = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.f56530b = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f56531c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f56535g = this.f56531c.setTitleText("");
        this.f56532d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.o = (LinearLayout) this.f56530b.findViewById(R.id.face_package_container);
        TextView textView = (TextView) this.f56530b.findViewById(R.id.top_view);
        this.p = textView;
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + d.b.b.e.p.l.g(this.f56529a.getPageActivity(), R.dimen.ds98);
        this.f56533e = (TbImageView) this.f56530b.findViewById(R.id.face_package_cover);
        this.f56534f = (TextView) this.f56530b.findViewById(R.id.face_package_title);
        this.f56536h = (TextView) this.f56530b.findViewById(R.id.face_package_price);
        this.i = (TextView) this.f56530b.findViewById(R.id.face_package_status);
        this.j = (TextView) this.f56530b.findViewById(R.id.face_package_btn);
        this.k = (TextView) this.f56530b.findViewById(R.id.face_package_info);
        this.t = (GridView) this.f56530b.findViewById(R.id.face_package_faces);
        TbImageView tbImageView = (TbImageView) this.f56530b.findViewById(R.id.face_package_title_tag);
        this.H = tbImageView;
        tbImageView.setDefaultResource(0);
        this.H.setDefaultBgResource(0);
        this.t.setSelection(-1);
        try {
            this.t.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.t.setOnItemClickListener(new a());
        this.l = (FrameLayout) this.f56530b.findViewById(R.id.face_package_downloading);
        this.m = (ImageView) this.f56530b.findViewById(R.id.face_package_downloading_up);
        this.n = (ImageView) this.f56530b.findViewById(R.id.face_package_downloading_cancel);
        TbadkApplication.getInst().getSkinType();
        this.I = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.J = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds202);
        this.v = new Handler();
        this.j.setOnClickListener(tbPageContext.getOrignalPage());
        this.n.setOnClickListener(tbPageContext.getOrignalPage());
        Bitmap cashBitmap = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_down);
        Bitmap cashBitmap2 = BitmapHelper.getCashBitmap(R.drawable.bg_content_buy_bar_up);
        this.r = cashBitmap.getWidth();
        this.q = cashBitmap2.getWidth();
        this.s = this.f56529a.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.w = new h(this.f56529a, R.style.common_alert_dialog);
        this.E = (ScrollView) this.f56530b.findViewById(R.id.container_scrollview);
        i(tbPageContext);
    }

    @SuppressLint({"ResourceAsColor"})
    public void A() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.f56529a.getResources().getString(R.string.downloaded));
        SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
    }

    public void B(long j, long j2) {
        this.j.setVisibility(8);
        this.l.setVisibility(0);
        int i = (int) (this.r * (((float) j2) / ((float) j)));
        int i2 = this.q;
        if (i < i2) {
            i = i2;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.width = i;
        this.m.setLayoutParams(layoutParams);
    }

    public void C(int i, Rect rect, FacePackageData facePackageData) {
        ArrayList<String> arrayList;
        if (i != this.G && (arrayList = facePackageData.face_dynamic_list) != null && i >= 0 && i <= arrayList.size()) {
            int i2 = this.G;
            if (i2 != -1) {
                v(i2, false);
            }
            this.G = i;
            this.t.setSelection(i);
            v(i, true);
            this.D = true;
            this.x.setVisibility(0);
            String str = SmallTailInfo.EMOTION_PREFIX + facePackageData.face_dynamic_list.get(i) + SmallTailInfo.EMOTION_SUFFIX;
            this.x.setTag(str);
            if (d.b.h0.z0.o.f()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.J;
                gifInfo.mGifWidth = this.I;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i);
                this.x.w0(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.J;
                gifInfo2.mGifWidth = this.I;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i);
                this.x.w0(gifInfo2);
            }
            this.z.x = rect.left - ((this.A - rect.width()) / 2);
            WindowManager.LayoutParams layoutParams = this.z;
            int i3 = rect.top - layoutParams.height;
            layoutParams.y = i3;
            int i4 = this.F;
            if (i3 < i4) {
                this.E.scrollBy(0, i3 - i4);
                this.z.y = this.F;
            }
            WindowManager.LayoutParams layoutParams2 = this.z;
            int i5 = layoutParams2.y;
            GridView gridView = this.t;
            layoutParams2.y = i5 + gridView.getChildAt(i - gridView.getFirstVisiblePosition()).getPaddingTop();
            if (!this.C) {
                this.y.addView(this.x, this.z);
                this.C = true;
                return;
            }
            this.y.updateViewLayout(this.x, this.z);
        }
    }

    public final void D() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.f56529a.getResources().getString(R.string.off_the_shelf));
        SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
    }

    public final void E() {
        Handler handler = this.v;
        if (handler != null) {
            handler.removeCallbacks(this.K);
            this.v.postDelayed(this.K, 90L);
        }
    }

    public void b(NoNetworkView.b bVar) {
        this.f56532d.a(bVar);
    }

    public void c(boolean z) {
        BdListViewHelper.c(this.p, BdListViewHelper.HeadType.DEFAULT, z);
    }

    public void d() {
        this.D = false;
        this.x.setVisibility(8);
        this.t.setSelection(-1);
        v(this.G, false);
        this.G = -1;
    }

    public TextView e() {
        return this.j;
    }

    public ImageView f() {
        return this.n;
    }

    public GridView g() {
        return this.t;
    }

    public void h() {
        h hVar = this.w;
        if (hVar != null) {
            d.b.b.e.m.g.b(hVar, this.f56529a);
        }
    }

    public final void i(TbPageContext<?> tbPageContext) {
        GifView gifView = new GifView(tbPageContext.getPageActivity());
        this.x = gifView;
        SkinManager.setBackgroundResource(gifView, R.drawable.bg_expression_bubble);
        this.x.setVisibility(8);
        this.x.setSupportNoImage(false);
        this.y = (WindowManager) tbPageContext.getPageActivity().getSystemService("window");
        this.z = new WindowManager.LayoutParams();
        this.A = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds216);
        int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(R.dimen.ds240);
        this.B = dimensionPixelSize;
        WindowManager.LayoutParams layoutParams = this.z;
        layoutParams.width = this.A;
        layoutParams.height = dimensionPixelSize;
        layoutParams.gravity = 51;
        layoutParams.format = -3;
        layoutParams.type = 1000;
        layoutParams.flags |= 56;
        this.F = d.b.b.e.p.l.r(tbPageContext.getPageActivity());
        if (MenuKeyUtils.hasSmartBar()) {
            WindowManager.LayoutParams layoutParams2 = this.z;
            layoutParams2.type = 1000;
            layoutParams2.flags = 25165832;
        }
    }

    public boolean j() {
        return this.D;
    }

    public void k() {
        TbImageView tbImageView = this.f56533e;
        if (tbImageView != null && tbImageView.getTag() != null) {
            this.f56533e.T(this.f56533e.getTag().toString(), 10, this.I, this.J, false);
        }
        TbImageView tbImageView2 = this.H;
        if (tbImageView2 == null || tbImageView2.getTag() == null) {
            return;
        }
        this.H.T(this.H.getTag().toString(), 10, this.I, this.J, false);
    }

    public void l(int i) {
        TbPageContext<FacePackageDetailActivity> tbPageContext = this.f56529a;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(i == 1);
            this.f56529a.getLayoutMode().j(this.f56530b);
        }
        NavigationBar navigationBar = this.f56531c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f56529a, i);
        }
        NoNetworkView noNetworkView = this.f56532d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f56529a, i);
        }
    }

    public void m() {
        NoNetworkView noNetworkView = this.f56532d;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.b.b.e.p.j.z()) {
            this.f56532d.e(false);
        }
    }

    public void n(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
    }

    public void o(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel == null) {
            return;
        }
        u(facePackageDetailModel);
    }

    public void p() {
        this.D = false;
        if (this.C) {
            this.C = false;
            this.y.removeView(this.x);
        }
    }

    public void q(NoNetworkView.b bVar) {
        this.f56532d.d(bVar);
    }

    public void r() {
        h hVar = this.w;
        if (hVar != null) {
            hVar.c();
        }
    }

    public final void s(FacePackageData facePackageData) {
        if (facePackageData == null || facePackageData.face_list == null) {
            return;
        }
        this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((d.b.b.e.p.l.k(this.f56529a.getPageActivity()) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
    }

    public void t(FacePackageData facePackageData) {
        if (facePackageData == null) {
            return;
        }
        j jVar = this.u;
        if (jVar == null) {
            j jVar2 = new j(this.f56529a.getPageActivity(), facePackageData.face_list);
            this.u = jVar2;
            this.t.setAdapter((ListAdapter) jVar2);
            return;
        }
        jVar.a(facePackageData.face_list);
        this.u.notifyDataSetChanged();
    }

    public void u(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel == null || facePackageDetailModel.A() == null || (facePackageData = facePackageDetailModel.A().faces_list) == null) {
            return;
        }
        if (facePackageDetailModel.C()) {
            facePackageData.downloading = 1;
        } else {
            facePackageData.downloading = 0;
        }
        this.o.setVisibility(0);
        this.f56533e.setTag(facePackageData.cover_url);
        this.f56534f.setText(facePackageData.pname);
        this.H.setTag(facePackageData.tag_url);
        TextView textView = this.f56536h;
        textView.setText(this.f56529a.getResources().getString(R.string.price_tip) + facePackageData.price);
        this.k.setText(facePackageData.pdesc);
        this.f56535g.setText(facePackageData.pname);
        s(facePackageData);
        n(facePackageDetailModel.getPid());
        t(facePackageData);
        E();
    }

    public final void v(int i, boolean z) {
        GridView gridView = this.t;
        ((ViewGroup) gridView.getChildAt(i - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void w(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel == null || facePackageDetailModel.A() == null || facePackageDetailModel.A().faces_list == null) {
            return;
        }
        FacePackageData facePackageData = facePackageDetailModel.A().faces_list;
        if (facePackageData.buy_status == 1) {
            this.i.setText(this.f56529a.getResources().getString(R.string.has_buy));
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
        switch (facePackageDetailModel.E()) {
            case 1:
                A();
                return;
            case 2:
            case 3:
                z();
                return;
            case 4:
                x();
                return;
            case 5:
                B(facePackageData.downloadTotal, facePackageData.downloadNow);
                return;
            case 6:
                D();
                return;
            default:
                return;
        }
    }

    public void x() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.f56529a.getResources().getString(R.string.buy_book));
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
    }

    public void y() {
        h hVar = this.w;
        if (hVar != null) {
            hVar.d();
            d.b.b.e.m.g.j(this.w, this.f56529a);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void z() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.f56529a.getResources().getString(R.string.can_download));
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
    }
}
