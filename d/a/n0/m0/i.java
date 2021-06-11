package d.a.n0.m0;

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
    public final TbPageContext<FacePackageDetailActivity> f60942a;

    /* renamed from: b  reason: collision with root package name */
    public final View f60943b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f60944c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f60945d;

    /* renamed from: e  reason: collision with root package name */
    public final TbImageView f60946e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f60947f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f60948g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f60949h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f60950i;
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
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
        this.f60942a = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.f60943b = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f60944c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f60948g = this.f60944c.setTitleText("");
        this.f60945d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.o = (LinearLayout) this.f60943b.findViewById(R.id.face_package_container);
        TextView textView = (TextView) this.f60943b.findViewById(R.id.top_view);
        this.p = textView;
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + d.a.c.e.p.l.g(this.f60942a.getPageActivity(), R.dimen.ds98);
        this.f60946e = (TbImageView) this.f60943b.findViewById(R.id.face_package_cover);
        this.f60947f = (TextView) this.f60943b.findViewById(R.id.face_package_title);
        this.f60949h = (TextView) this.f60943b.findViewById(R.id.face_package_price);
        this.f60950i = (TextView) this.f60943b.findViewById(R.id.face_package_status);
        this.j = (TextView) this.f60943b.findViewById(R.id.face_package_btn);
        this.k = (TextView) this.f60943b.findViewById(R.id.face_package_info);
        this.t = (GridView) this.f60943b.findViewById(R.id.face_package_faces);
        TbImageView tbImageView = (TbImageView) this.f60943b.findViewById(R.id.face_package_title_tag);
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
        this.l = (FrameLayout) this.f60943b.findViewById(R.id.face_package_downloading);
        this.m = (ImageView) this.f60943b.findViewById(R.id.face_package_downloading_up);
        this.n = (ImageView) this.f60943b.findViewById(R.id.face_package_downloading_cancel);
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
        this.s = this.f60942a.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.w = new h(this.f60942a, R.style.common_alert_dialog);
        this.E = (ScrollView) this.f60943b.findViewById(R.id.container_scrollview);
        i(tbPageContext);
    }

    @SuppressLint({"ResourceAsColor"})
    public void A() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.f60942a.getResources().getString(R.string.downloaded));
        SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
    }

    public void B(long j, long j2) {
        this.j.setVisibility(8);
        this.l.setVisibility(0);
        int i2 = (int) (this.r * (((float) j2) / ((float) j)));
        int i3 = this.q;
        if (i2 < i3) {
            i2 = i3;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
        layoutParams.width = i2;
        this.m.setLayoutParams(layoutParams);
    }

    public void C(int i2, Rect rect, FacePackageData facePackageData) {
        ArrayList<String> arrayList;
        if (i2 != this.G && (arrayList = facePackageData.face_dynamic_list) != null && i2 >= 0 && i2 <= arrayList.size()) {
            int i3 = this.G;
            if (i3 != -1) {
                v(i3, false);
            }
            this.G = i2;
            this.t.setSelection(i2);
            v(i2, true);
            this.D = true;
            this.x.setVisibility(0);
            String str = SmallTailInfo.EMOTION_PREFIX + facePackageData.face_dynamic_list.get(i2) + SmallTailInfo.EMOTION_SUFFIX;
            this.x.setTag(str);
            if (d.a.m0.z0.o.f()) {
                GifInfo gifInfo = new GifInfo();
                gifInfo.mGid = facePackageData.pid + "";
                gifInfo.mSharpText = str;
                gifInfo.mGifHeight = this.J;
                gifInfo.mGifWidth = this.I;
                gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i2);
                this.x.w0(gifInfo);
            } else {
                GifInfo gifInfo2 = new GifInfo();
                gifInfo2.mGid = facePackageData.pid + "";
                gifInfo2.mGifHeight = this.J;
                gifInfo2.mGifWidth = this.I;
                gifInfo2.mSharpText = str;
                gifInfo2.mStaticUrl = facePackageData.face_list.get(i2);
                this.x.w0(gifInfo2);
            }
            this.z.x = rect.left - ((this.A - rect.width()) / 2);
            WindowManager.LayoutParams layoutParams = this.z;
            int i4 = rect.top - layoutParams.height;
            layoutParams.y = i4;
            int i5 = this.F;
            if (i4 < i5) {
                this.E.scrollBy(0, i4 - i5);
                this.z.y = this.F;
            }
            WindowManager.LayoutParams layoutParams2 = this.z;
            int i6 = layoutParams2.y;
            GridView gridView = this.t;
            layoutParams2.y = i6 + gridView.getChildAt(i2 - gridView.getFirstVisiblePosition()).getPaddingTop();
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
        this.j.setText(this.f60942a.getResources().getString(R.string.off_the_shelf));
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
        this.f60945d.a(bVar);
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
            d.a.c.e.m.g.b(hVar, this.f60942a);
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
        this.F = d.a.c.e.p.l.r(tbPageContext.getPageActivity());
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
        TbImageView tbImageView = this.f60946e;
        if (tbImageView != null && tbImageView.getTag() != null) {
            this.f60946e.R(this.f60946e.getTag().toString(), 10, this.I, this.J, false);
        }
        TbImageView tbImageView2 = this.H;
        if (tbImageView2 == null || tbImageView2.getTag() == null) {
            return;
        }
        this.H.R(this.H.getTag().toString(), 10, this.I, this.J, false);
    }

    public void l(int i2) {
        TbPageContext<FacePackageDetailActivity> tbPageContext = this.f60942a;
        if (tbPageContext != null) {
            tbPageContext.getLayoutMode().k(i2 == 1);
            this.f60942a.getLayoutMode().j(this.f60943b);
        }
        NavigationBar navigationBar = this.f60944c;
        if (navigationBar != null) {
            navigationBar.onChangeSkinType(this.f60942a, i2);
        }
        NoNetworkView noNetworkView = this.f60945d;
        if (noNetworkView != null) {
            noNetworkView.c(this.f60942a, i2);
        }
    }

    public void m() {
        NoNetworkView noNetworkView = this.f60945d;
        if (noNetworkView != null && noNetworkView.getVisibility() == 0 && d.a.c.e.p.j.z()) {
            this.f60945d.e(false);
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
        this.f60945d.d(bVar);
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
        this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((d.a.c.e.p.l.k(this.f60942a.getPageActivity()) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
    }

    public void t(FacePackageData facePackageData) {
        if (facePackageData == null) {
            return;
        }
        j jVar = this.u;
        if (jVar == null) {
            j jVar2 = new j(this.f60942a.getPageActivity(), facePackageData.face_list);
            this.u = jVar2;
            this.t.setAdapter((ListAdapter) jVar2);
            return;
        }
        jVar.a(facePackageData.face_list);
        this.u.notifyDataSetChanged();
    }

    public void u(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        if (facePackageDetailModel == null || facePackageDetailModel.E() == null || (facePackageData = facePackageDetailModel.E().faces_list) == null) {
            return;
        }
        if (facePackageDetailModel.G()) {
            facePackageData.downloading = 1;
        } else {
            facePackageData.downloading = 0;
        }
        this.o.setVisibility(0);
        this.f60946e.setTag(facePackageData.cover_url);
        this.f60947f.setText(facePackageData.pname);
        this.H.setTag(facePackageData.tag_url);
        TextView textView = this.f60949h;
        textView.setText(this.f60942a.getResources().getString(R.string.price_tip) + facePackageData.price);
        this.k.setText(facePackageData.pdesc);
        this.f60948g.setText(facePackageData.pname);
        s(facePackageData);
        n(facePackageDetailModel.getPid());
        t(facePackageData);
        E();
    }

    public final void v(int i2, boolean z) {
        GridView gridView = this.t;
        ((ViewGroup) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
    }

    public void w(FacePackageDetailModel facePackageDetailModel) {
        if (facePackageDetailModel == null || facePackageDetailModel.E() == null || facePackageDetailModel.E().faces_list == null) {
            return;
        }
        FacePackageData facePackageData = facePackageDetailModel.E().faces_list;
        if (facePackageData.buy_status == 1) {
            this.f60950i.setText(this.f60942a.getResources().getString(R.string.has_buy));
            this.f60950i.setVisibility(0);
        } else {
            this.f60950i.setVisibility(8);
        }
        switch (facePackageDetailModel.I()) {
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
        this.j.setText(this.f60942a.getResources().getString(R.string.buy_book));
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
    }

    public void y() {
        h hVar = this.w;
        if (hVar != null) {
            hVar.d();
            d.a.c.e.m.g.j(this.w, this.f60942a);
        }
    }

    @SuppressLint({"ResourceAsColor"})
    public void z() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.j.setText(this.f60942a.getResources().getString(R.string.can_download));
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
        SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
    }
}
