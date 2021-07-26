package d.a.q0.p0;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.compatible.menukey.MenuKeyUtils;
import java.util.ArrayList;
import java.util.LinkedList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes8.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public final ScrollView E;
    public int F;
    public int G;
    public final TbImageView H;
    public int I;
    public int J;
    public final Runnable K;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<FacePackageDetailActivity> f61798a;

    /* renamed from: b  reason: collision with root package name */
    public final View f61799b;

    /* renamed from: c  reason: collision with root package name */
    public final NavigationBar f61800c;

    /* renamed from: d  reason: collision with root package name */
    public final NoNetworkView f61801d;

    /* renamed from: e  reason: collision with root package name */
    public final TbImageView f61802e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f61803f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f61804g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f61805h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f61806i;
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

    /* loaded from: classes8.dex */
    public class a implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f61807e;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61807e = iVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                this.f61807e.t.setSelection(-1);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f61808e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61808e = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f61808e.k();
                } catch (Exception e2) {
                    BdLog.detailException(e2);
                }
            }
        }
    }

    public i(TbPageContext<FacePackageDetailActivity> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.G = -1;
        this.K = new b(this);
        this.f61798a = tbPageContext;
        tbPageContext.getOrignalPage().setContentView(R.layout.face_package_detail_activity);
        this.f61799b = tbPageContext.getPageActivity().findViewById(R.id.face_package);
        NavigationBar navigationBar = (NavigationBar) tbPageContext.getPageActivity().findViewById(R.id.view_navigation_bar);
        this.f61800c = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f61804g = this.f61800c.setTitleText("");
        this.f61801d = (NoNetworkView) tbPageContext.getPageActivity().findViewById(R.id.view_no_network);
        this.o = (LinearLayout) this.f61799b.findViewById(R.id.face_package_container);
        TextView textView = (TextView) this.f61799b.findViewById(R.id.top_view);
        this.p = textView;
        ((LinearLayout.LayoutParams) textView.getLayoutParams()).height = UtilHelper.getLightStatusBarHeight() + d.a.d.e.p.l.g(this.f61798a.getPageActivity(), R.dimen.ds98);
        this.f61802e = (TbImageView) this.f61799b.findViewById(R.id.face_package_cover);
        this.f61803f = (TextView) this.f61799b.findViewById(R.id.face_package_title);
        this.f61805h = (TextView) this.f61799b.findViewById(R.id.face_package_price);
        this.f61806i = (TextView) this.f61799b.findViewById(R.id.face_package_status);
        this.j = (TextView) this.f61799b.findViewById(R.id.face_package_btn);
        this.k = (TextView) this.f61799b.findViewById(R.id.face_package_info);
        this.t = (GridView) this.f61799b.findViewById(R.id.face_package_faces);
        TbImageView tbImageView = (TbImageView) this.f61799b.findViewById(R.id.face_package_title_tag);
        this.H = tbImageView;
        tbImageView.setDefaultResource(0);
        this.H.setDefaultBgResource(0);
        this.t.setSelection(-1);
        try {
            this.t.setOnItemLongClickListener(tbPageContext.getOrignalPage());
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.t.setOnItemClickListener(new a(this));
        this.l = (FrameLayout) this.f61799b.findViewById(R.id.face_package_downloading);
        this.m = (ImageView) this.f61799b.findViewById(R.id.face_package_downloading_up);
        this.n = (ImageView) this.f61799b.findViewById(R.id.face_package_downloading_cancel);
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
        this.s = this.f61798a.getResources().getDimensionPixelSize(R.dimen.ds22);
        this.w = new h(this.f61798a, R.style.common_alert_dialog);
        this.E = (ScrollView) this.f61799b.findViewById(R.id.container_scrollview);
        i(tbPageContext);
    }

    @SuppressLint({"ResourceAsColor"})
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.f61798a.getResources().getString(R.string.downloaded));
            SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
        }
    }

    public void B(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
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
    }

    public void C(int i2, Rect rect, FacePackageData facePackageData) {
        ArrayList<String> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, rect, facePackageData) == null) || i2 == this.G || (arrayList = facePackageData.face_dynamic_list) == null || i2 < 0 || i2 > arrayList.size()) {
            return;
        }
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
        if (d.a.p0.b1.o.f()) {
            GifInfo gifInfo = new GifInfo();
            gifInfo.mGid = facePackageData.pid + "";
            gifInfo.mSharpText = str;
            gifInfo.mGifHeight = this.J;
            gifInfo.mGifWidth = this.I;
            gifInfo.mDynamicUrl = facePackageData.face_dynamic_list.get(i2);
            this.x.k0(gifInfo);
        } else {
            GifInfo gifInfo2 = new GifInfo();
            gifInfo2.mGid = facePackageData.pid + "";
            gifInfo2.mGifHeight = this.J;
            gifInfo2.mGifWidth = this.I;
            gifInfo2.mSharpText = str;
            gifInfo2.mStaticUrl = facePackageData.face_list.get(i2);
            this.x.k0(gifInfo2);
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

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.f61798a.getResources().getString(R.string.off_the_shelf));
            SkinManager.setViewTextColor(this.j, R.color.common_color_10172, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_content_buy_d);
        }
    }

    public final void E() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.v) == null) {
            return;
        }
        handler.removeCallbacks(this.K);
        this.v.postDelayed(this.K, 90L);
    }

    public void b(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.f61801d.a(bVar);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            BdListViewHelper.c(this.p, BdListViewHelper.HeadType.DEFAULT, z);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.D = false;
            this.x.setVisibility(8);
            this.t.setSelection(-1);
            v(this.G, false);
            this.G = -1;
        }
    }

    public TextView e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j : (TextView) invokeV.objValue;
    }

    public ImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.n : (ImageView) invokeV.objValue;
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.t : (GridView) invokeV.objValue;
    }

    public void h() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.w) == null) {
            return;
        }
        d.a.d.e.m.g.b(hVar, this.f61798a);
    }

    public final void i(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbPageContext) == null) {
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
            this.F = d.a.d.e.p.l.r(tbPageContext.getPageActivity());
            if (MenuKeyUtils.hasSmartBar()) {
                WindowManager.LayoutParams layoutParams2 = this.z;
                layoutParams2.type = 1000;
                layoutParams2.flags = 25165832;
            }
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TbImageView tbImageView = this.f61802e;
            if (tbImageView != null && tbImageView.getTag() != null) {
                this.f61802e.J(this.f61802e.getTag().toString(), 10, this.I, this.J, false);
            }
            TbImageView tbImageView2 = this.H;
            if (tbImageView2 == null || tbImageView2.getTag() == null) {
                return;
            }
            this.H.J(this.H.getTag().toString(), 10, this.I, this.J, false);
        }
    }

    public void l(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            TbPageContext<FacePackageDetailActivity> tbPageContext = this.f61798a;
            if (tbPageContext != null) {
                tbPageContext.getLayoutMode().k(i2 == 1);
                this.f61798a.getLayoutMode().j(this.f61799b);
            }
            NavigationBar navigationBar = this.f61800c;
            if (navigationBar != null) {
                navigationBar.onChangeSkinType(this.f61798a, i2);
            }
            NoNetworkView noNetworkView = this.f61801d;
            if (noNetworkView != null) {
                noNetworkView.c(this.f61798a, i2);
            }
        }
    }

    public void m() {
        NoNetworkView noNetworkView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && (noNetworkView = this.f61801d) != null && noNetworkView.getVisibility() == 0 && d.a.d.e.p.j.z()) {
            this.f61801d.e(false);
        }
    }

    public void n(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, str) == null) || str == null || str.length() <= 0) {
            return;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new QueryDownloadMessage(linkedList));
    }

    public void o(FacePackageDetailModel facePackageDetailModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, facePackageDetailModel) == null) || facePackageDetailModel == null) {
            return;
        }
        u(facePackageDetailModel);
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.D = false;
            if (this.C) {
                this.C = false;
                this.y.removeView(this.x);
            }
        }
    }

    public void q(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bVar) == null) {
            this.f61801d.d(bVar);
        }
    }

    public void r() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || (hVar = this.w) == null) {
            return;
        }
        hVar.c();
    }

    public final void s(FacePackageData facePackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, facePackageData) == null) || facePackageData == null || facePackageData.face_list == null) {
            return;
        }
        this.t.setLayoutParams(new LinearLayout.LayoutParams(-1, ((d.a.d.e.p.l.k(this.f61798a.getPageActivity()) - (this.s * 2)) / 4) * ((int) Math.ceil(facePackageData.face_list.size() / 4.0f))));
    }

    public void t(FacePackageData facePackageData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, facePackageData) == null) || facePackageData == null) {
            return;
        }
        j jVar = this.u;
        if (jVar == null) {
            j jVar2 = new j(this.f61798a.getPageActivity(), facePackageData.face_list);
            this.u = jVar2;
            this.t.setAdapter((ListAdapter) jVar2);
            return;
        }
        jVar.a(facePackageData.face_list);
        this.u.notifyDataSetChanged();
    }

    public void u(FacePackageDetailModel facePackageDetailModel) {
        FacePackageData facePackageData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, facePackageDetailModel) == null) || facePackageDetailModel == null || facePackageDetailModel.E() == null || (facePackageData = facePackageDetailModel.E().faces_list) == null) {
            return;
        }
        if (facePackageDetailModel.G()) {
            facePackageData.downloading = 1;
        } else {
            facePackageData.downloading = 0;
        }
        this.o.setVisibility(0);
        this.f61802e.setTag(facePackageData.cover_url);
        this.f61803f.setText(facePackageData.pname);
        this.H.setTag(facePackageData.tag_url);
        TextView textView = this.f61805h;
        textView.setText(this.f61798a.getResources().getString(R.string.price_tip) + facePackageData.price);
        this.k.setText(facePackageData.pdesc);
        this.f61804g.setText(facePackageData.pname);
        s(facePackageData);
        n(facePackageDetailModel.getPid());
        t(facePackageData);
        E();
    }

    public final void v(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            GridView gridView = this.t;
            ((ViewGroup) gridView.getChildAt(i2 - gridView.getFirstVisiblePosition())).getChildAt(0).setSelected(z);
        }
    }

    public void w(FacePackageDetailModel facePackageDetailModel) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, facePackageDetailModel) == null) || facePackageDetailModel == null || facePackageDetailModel.E() == null || facePackageDetailModel.E().faces_list == null) {
            return;
        }
        FacePackageData facePackageData = facePackageDetailModel.E().faces_list;
        if (facePackageData.buy_status == 1) {
            this.f61806i.setText(this.f61798a.getResources().getString(R.string.has_buy));
            this.f61806i.setVisibility(0);
        } else {
            this.f61806i.setVisibility(8);
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.f61798a.getResources().getString(R.string.buy_book));
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
        }
    }

    public void y() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (hVar = this.w) == null) {
            return;
        }
        hVar.d();
        d.a.d.e.m.g.j(this.w, this.f61798a);
    }

    @SuppressLint({"ResourceAsColor"})
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.j.setVisibility(0);
            this.l.setVisibility(8);
            this.j.setText(this.f61798a.getResources().getString(R.string.can_download));
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0101, 1);
            SkinManager.setBackgroundResource(this.j, R.drawable.btn_all_blue);
        }
    }
}
