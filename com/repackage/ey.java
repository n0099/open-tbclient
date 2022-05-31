package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mw;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class ey extends tw {
    public static /* synthetic */ Interceptable $ic;
    public static final int r;
    public static int s;
    public transient /* synthetic */ FieldHolder $fh;
    public int h;
    public int i;
    public int j;
    public Context k;
    public om4 l;
    public VideoImageNoPlayerLayout m;
    public int n;
    public String o;
    public int p;
    public jy q;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;

        public a(ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eyVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            ey eyVar;
            mw.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = (eyVar = this.a).e) == null) {
                return;
            }
            aVar.a(eyVar.l);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ey a;

        public b(ey eyVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eyVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eyVar;
        }

        @Override // com.repackage.jy
        public void a(om4 om4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, om4Var) == null) || this.a.q == null) {
                return;
            }
            this.a.q.a(this.a.l);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964040751, "Lcom/repackage/ey;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964040751, "Lcom/repackage/ey;");
                return;
            }
        }
        r = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
        s = li.k(TbadkCoreApplication.getInst());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ey(Context context) {
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
        int i3 = s;
        this.h = i3;
        this.i = i3 / 2;
        this.j = i3 / 3;
        this.n = 0;
        this.p = 3;
        this.k = context;
        this.m = new VideoImageNoPlayerLayout(context);
        n(Boolean.TRUE);
    }

    @Override // com.repackage.mw
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : (View) invokeV.objValue;
    }

    @Override // com.repackage.mw
    public void l(nw5<om4> nw5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, nw5Var) == null) {
            super.l(nw5Var);
            this.m.setOnCardSubClickListener(nw5Var);
        }
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (this.p != i) {
                this.m.h(tbPageContext, i);
            }
            this.p = i;
        }
    }

    public Rect u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? ThreadCardUtils.computeViewArea(this.m.c) : (Rect) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
        if (r3 != r11.height) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f1, code lost:
        if (r3 != r11.height) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f4, code lost:
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f5, code lost:
        r1 = com.baidu.tbadk.abtest.helper.HomeGroupUbsUIHelper.handleTransmitVerticalVideoSize(r11, r0, r2, r3, r5);
     */
    @Override // com.repackage.bx
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, om4Var) == null) {
            int k = li.k(TbadkCoreApplication.getInst());
            if (k != this.n) {
                s = li.k(TbadkCoreApplication.getInst());
                if (!"pb".equals(this.o)) {
                    this.h = s - r;
                } else {
                    this.h = s;
                }
                int i = this.h;
                this.i = i / 2;
                this.j = i / 3;
                this.n = k;
            }
            this.l = om4Var;
            if (om4Var != null && om4Var.getThreadData() != null && this.l.getThreadData().originalThreadData != null && !this.l.getThreadData().originalThreadData.m && !this.l.getThreadData().shouldShowBlockedState()) {
                this.m.setVisibility(0);
                this.m.a(om4Var);
                ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = this.m.j.getLayoutParams();
                int i2 = layoutParams.width;
                int i3 = layoutParams.height;
                boolean z = true;
                if (this.l.getThreadData().originalThreadData.r.is_vertical.intValue() == 1) {
                    VideoInfo videoInfo = this.l.getThreadData().originalThreadData.r;
                    if (videoInfo == null) {
                        return;
                    }
                    int i4 = (this.i / 9) * 16;
                    int i5 = this.j;
                    int intValue = videoInfo.video_width.intValue();
                    int intValue2 = videoInfo.video_height.intValue();
                    layoutParams.width = this.h;
                    layoutParams2.width = this.i;
                    r1 = i2 != layoutParams.width;
                    if (intValue != 0 && intValue2 != 0) {
                        int i6 = (int) (((intValue2 * 1.0f) / intValue) * this.i);
                        if (i6 < i5) {
                            i4 = i5;
                        } else if (i6 <= i4) {
                            i4 = i6;
                        }
                        layoutParams.height = i4;
                        layoutParams2.height = i4;
                    } else {
                        layoutParams.height = i4;
                        layoutParams2.height = i4;
                    }
                } else {
                    int i7 = this.h;
                    layoutParams.width = i7;
                    layoutParams2.width = i7;
                    layoutParams.height = ((i7 / 16) * 9) - li.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                    layoutParams2.height = ((this.h / 16) * 9) - li.f(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                    if (i3 != layoutParams.height || i2 != layoutParams.width) {
                        r1 = true;
                    }
                }
                if (r1) {
                    this.m.setLayoutParams(layoutParams);
                    this.m.j.setLayoutParams(layoutParams2);
                }
                this.m.setJumpToPbListener(new a(this));
                this.m.setData(this.l);
                d();
                return;
            }
            this.m.setVisibility(8);
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.o = str;
        }
    }

    public void x(mw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, aVar) == null) {
            this.e = aVar;
        }
    }

    public void y(jy jyVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jyVar) == null) {
            this.q = jyVar;
            if (jyVar != null) {
                z();
            }
        }
    }

    public final void z() {
        VideoImageNoPlayerLayout videoImageNoPlayerLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (videoImageNoPlayerLayout = this.m) == null) {
            return;
        }
        videoImageNoPlayerLayout.setVideoAreaClickListener(new b(this));
    }
}
