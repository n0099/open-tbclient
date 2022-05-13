package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vz;
import com.repackage.zx;
/* loaded from: classes7.dex */
public abstract class sz extends zx<zn4> implements w68 {
    public static /* synthetic */ Interceptable $ic;
    public static final int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public zn4 h;
    public RoundCornerFrameLayout i;
    public r78 j;
    public String k;
    public String l;
    public BdUniqueId m;
    public int n;
    public boolean o;
    public View.OnClickListener p;
    public final View.OnClickListener q;
    public final View.OnClickListener r;
    public vz.b s;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup.LayoutParams a;
        public final /* synthetic */ sz b;

        public a(sz szVar, ViewGroup.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {szVar, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = szVar;
            this.a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                zn4 zn4Var = this.b.h;
                if (zn4Var != null && zn4Var.getThreadData().getThreadVideoInfo().is_vertical.intValue() != 1) {
                    this.a.width = this.b.f.getWidth();
                    this.a.height = (this.b.f.getWidth() / 16) * 9;
                }
                this.b.i.setLayoutParams(this.a);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;

        public b(sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = szVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            zn4 zn4Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (zn4Var = this.a.h) == null || zn4Var.getThreadData() == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.i);
            sz szVar = this.a;
            Context context = szVar.b;
            ThreadData threadData = szVar.h.getThreadData();
            sz szVar2 = this.a;
            String str = szVar2.k;
            fd5.c(false, context, threadData, 0, computeViewArea, "from_nani_video", "personalize_page", "", str, str, szVar2.h.getThreadData().isJumpToFrsVideoTabPlay);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;

        public c(sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = szVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            sz szVar;
            zx.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = (szVar = this.a).e) == null) {
                return;
            }
            aVar.a(szVar.h);
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;

        public d(sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = szVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.d() == null) {
                return;
            }
            this.a.d().a(view2, this.a.h);
        }
    }

    /* loaded from: classes7.dex */
    public class e implements vz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sz a;

        public e(sz szVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {szVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = szVar;
        }

        @Override // com.repackage.vz.b
        public boolean a(vz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                if (aVar.b() == 1) {
                    sz szVar = this.a;
                    fx5.l(szVar.g, szVar.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                    return false;
                } else if (aVar.b() == 2) {
                    r78 r78Var = this.a.j;
                    if (r78Var != null) {
                        r78Var.onScroll();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 3) {
                    r78 r78Var2 = this.a.j;
                    if (r78Var2 != null) {
                        r78Var2.onVolumeUp();
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 6) {
                    r78 r78Var3 = this.a.j;
                    if (r78Var3 != null) {
                        return r78Var3.onBackPress();
                    }
                    return false;
                } else if (aVar.b() == 7) {
                    RoundCornerFrameLayout roundCornerFrameLayout = this.a.i;
                    if (roundCornerFrameLayout != null) {
                        roundCornerFrameLayout.d(((Boolean) aVar.c()).booleanValue());
                        return false;
                    }
                    return false;
                } else if (aVar.b() == 8 && this.a.j != null && (aVar.c() instanceof Boolean)) {
                    return this.a.j.onBackground(((Boolean) aVar.c()).booleanValue());
                } else {
                    return false;
                }
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964027266, "Lcom/repackage/sz;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964027266, "Lcom/repackage/sz;");
                return;
            }
        }
        t = (mi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + mi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
        int k = mi.k(TbadkCoreApplication.getInst());
        u = k;
        int i = k - t;
        v = i;
        w = (i / 2) * 3;
        x = i / 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = 0;
        this.o = false;
        this.p = new b(this);
        this.q = new c(this);
        this.r = new d(this);
        this.s = new e(this);
    }

    @Override // com.repackage.zx
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f == null) {
                if (TbadkCoreApplication.getInst().getPersonalizeViewData().k != null && TbadkCoreApplication.getInst().getPersonalizeViewData().k.getParent() == null) {
                    this.f = TbadkCoreApplication.getInst().getPersonalizeViewData().k;
                } else {
                    this.f = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d01c4, (ViewGroup) null, true);
                }
                this.g = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0923a3);
                this.i = (RoundCornerFrameLayout) this.f.findViewById(R.id.obfuscated_res_0x7f090aa0);
                r78 p = p();
                this.j = p;
                p.setUniqueId(this.m);
                this.j.setFrom(this.k);
                this.j.setStageType(this.l);
            }
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j.getCurrentPosition() : invokeV.intValue;
    }

    @Override // com.repackage.w68
    public String getPlayUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            zn4 zn4Var = this.h;
            if (zn4Var == null || zn4Var.getThreadData() == null) {
                return null;
            }
            return this.h.getThreadData().getVideoUrl();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.repackage.w68
    public View getVideoContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.i : (View) invokeV.objValue;
    }

    @Override // com.repackage.zx
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i(1, this.s);
            i(2, this.s);
            i(3, this.s);
            i(6, this.s);
            i(7, this.s);
            i(8, this.s);
        }
    }

    @Override // com.repackage.w68
    public boolean isFullScreen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            r78 r78Var = this.j;
            if (r78Var == null) {
                return false;
            }
            return r78Var.isFullScreen();
        }
        return invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlayStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.j.isPlaying() : invokeV.booleanValue;
    }

    @Override // com.repackage.w68
    public boolean isPlaying() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.j.isPlaying() : invokeV.booleanValue;
    }

    public r78 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.j : (r78) invokeV.objValue;
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        zn4 zn4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048586, this, tbPageContext, i) == null) || (zn4Var = this.h) == null || zn4Var.getThreadData() == null) {
            return;
        }
        fx5.l(this.g, this.h.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.i.c(i);
        this.i.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public abstract r78 p();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b5, code lost:
        if (r1 != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (r1 != r2) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00bc, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
        r0 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleVerticalVideoSize(r11, r8, r10.j, r0, r1);
     */
    @Override // com.repackage.oy
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(zn4 zn4Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, zn4Var) == null) {
            int k = mi.k(TbadkCoreApplication.getInst());
            if (k != this.n) {
                int k2 = mi.k(TbadkCoreApplication.getInst());
                u = k2;
                int i = k2 - t;
                v = i;
                w = i / 2;
                x = i / 3;
                this.n = k;
            }
            this.h = zn4Var;
            if (zn4Var == null || zn4Var.getThreadData() == null || this.h.getThreadData().getThreadVideoInfo() == null) {
                return;
            }
            this.j.setData(zn4Var.getThreadData());
            ViewGroup.LayoutParams layoutParams = this.i.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = layoutParams.height;
            boolean z2 = false;
            if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                int i4 = (w / 9) * 16;
                int i5 = x;
                int intValue = this.h.getThreadData().getThreadVideoInfo().video_width.intValue();
                int intValue2 = this.h.getThreadData().getThreadVideoInfo().video_height.intValue();
                int i6 = w;
                layoutParams.width = i6;
                boolean z3 = i2 != i6;
                if (intValue != 0 && intValue2 != 0) {
                    int i7 = (int) (((intValue2 * 1.0f) / intValue) * w);
                    if (i7 < i5) {
                        i4 = i5;
                    } else if (i7 <= i4) {
                        i4 = i7;
                    }
                    layoutParams.height = i4;
                } else {
                    layoutParams.height = i4;
                }
            } else {
                int i8 = v;
                layoutParams.width = i8;
                int i9 = (i8 / 16) * 9;
                layoutParams.height = i9;
                z = (i3 == i9 && i2 == i8) ? false : true;
            }
            if (z) {
                if (this.h.getThreadData().getThreadVideoInfo().is_vertical.intValue() == 1) {
                    this.i.setLayoutParams(layoutParams);
                } else {
                    this.i.post(new a(this, layoutParams));
                }
            }
            if (this.h.getThreadData().isBJHVideoDynamicThreadType()) {
                this.g.setMaxLines(5);
                ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), v, this.o);
            } else {
                this.g.setMaxLines(2);
                ThreadCardUtils.setTitle(this.g, this.h.getThreadData(), v, 2, this.o);
            }
            TextView textView = this.g;
            ThreadCardUtils.dealMainViewTopMargin(this.i, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            if (this.e != null) {
                this.j.setJumpToPbClickListener(this.q);
            }
            if (d() != null) {
                this.j.setAfterClickListener(this.r);
            }
            TextView textView2 = this.g;
            if (textView2 == null || this.f == null) {
                return;
            }
            textView2.setOnClickListener(this.p);
            this.g.setMovementMethod(LinkMovementMethod.getInstance());
            this.f.setOnClickListener(this.p);
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }

    @Override // com.repackage.w68
    public void startPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Context context = this.b;
            if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
                this.j.startPlay();
            }
        }
    }

    @Override // com.repackage.w68
    public void stopPlay() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.j.stopPlay();
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.k = str;
            r78 r78Var = this.j;
            if (r78Var != null) {
                r78Var.setFrom(str);
            }
        }
    }

    public void u(zx.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void v(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.o = z;
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bdUniqueId) == null) {
            this.m = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            this.l = str;
            r78 r78Var = this.j;
            if (r78Var != null) {
                r78Var.setStageType(str);
            }
        }
    }

    public void y(m78 m78Var) {
        r78 r78Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, m78Var) == null) || (r78Var = this.j) == null) {
            return;
        }
        r78Var.setStatistic(m78Var);
    }
}
