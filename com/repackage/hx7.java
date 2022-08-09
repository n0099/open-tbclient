package com.repackage;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.MetaData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbTopCommenFloorItemViewHolder;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hu7;
import com.repackage.mz5;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class hx7 extends bw7<PostData, PbTopCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public TbRichTextView.s h;
    public boolean i;
    public float j;
    public String k;
    public ft7 l;
    public View.OnClickListener m;
    public TbRichTextView.y n;
    public hu7 o;
    public View.OnLongClickListener p;
    public boolean q;
    public int r;
    public boolean s;
    public int t;
    public String u;
    public fg<ConstrainImageLayout> v;
    public fg<TbImageView> w;
    public hu7 x;

    /* loaded from: classes6.dex */
    public class a implements gg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public a(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.mContext) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements gg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public b(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.gg
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.gg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.mContext);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements hu7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hx7 a;

        public c(hx7 hx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hx7Var;
        }

        @Override // com.repackage.hu7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.o != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.m == null) {
                        this.a.o.a(view2);
                        this.a.o.onSingleTapConfirmed(motionEvent);
                    } else {
                        this.a.m.onClick(view2);
                        PbFragment pbFragment = this.a.b;
                        if (pbFragment != null) {
                            pbFragment.d7(true);
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.hu7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || !((pbFragment = this.a.b) == null || pbFragment.S5() == null || this.a.b.S5().H1())) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.N(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.N((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ hx7 c;

        public d(hx7 hx7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbTopCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hx7Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.Q.getVisibility() == 8;
                this.c.K(this.a, !z, this.b.E());
                this.b.K0(!z);
                this.c.k0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment == null || pbFragment.S5() == null || this.c.b.S5().l1() == null || this.c.b.S5().R0() == null || z || this.a.getView().getTop() >= this.c.b.S5().l1().getMeasuredHeight()) {
                    return;
                }
                this.c.b.S5().R0().setSelectionFromTop(ListUtils.getPosition(this.c.b.S5().R0().getData(), this.b) + this.c.b.S5().R0().getHeaderViewsCount(), this.c.b.S5().l1().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;

        public e(hx7 hx7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l0.setVisibility(8);
                this.a.Y.setVisibility(0);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ String[] b;
        public final /* synthetic */ PostData c;
        public final /* synthetic */ int d;
        public final /* synthetic */ hx7 e;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ f f;

            public a(f fVar, int i, int i2, int i3, int i4, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = fVar;
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
                this.e = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    int h = lx7.h(this.a, this.b, this.f.a.h.getWidth(), this.c, this.d, this.e);
                    f fVar = this.f;
                    fVar.e.H(fVar.c, fVar.a, h, fVar.d);
                }
            }
        }

        public f(hx7 hx7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, String[] strArr, PostData postData, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbTopCommenFloorItemViewHolder, strArr, postData, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = hx7Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = strArr;
            this.c = postData;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.f.getMeasuredWidth();
                boolean d0 = this.e.d0();
                boolean z = false;
                int width = !StringUtils.isNull(this.b[0]) ? this.a.h.getWidth() : 0;
                int width2 = this.a.H.getVisibility() == 8 ? 0 : this.a.H.getWidth() + lx7.c + lx7.b;
                int width3 = this.a.j.getVisibility() == 8 ? 0 : this.a.j.getWidth() + lx7.b;
                int width4 = this.a.F.getVisibility() == 8 ? 0 : this.a.F.getWidth() + lx7.b;
                int h = lx7.h(measuredWidth, width2, width, width3, width4, d0);
                if (h <= 0 && !StringUtils.isNull(this.b[0]) && if5.d(this.b[0]) > lx7.g()) {
                    String[] strArr = this.b;
                    strArr[0] = if5.n(strArr[0], lx7.g());
                    TextView textView = this.a.h;
                    textView.setText(this.b[0] + StringHelper.STRING_MORE);
                    z = true;
                }
                if (this.a.h.getText() != null) {
                    PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = this.a;
                    pbTopCommenFloorItemViewHolder.g.setText(pbTopCommenFloorItemViewHolder.h.getText());
                }
                if (!z) {
                    this.e.H(this.c, this.a, h, this.d);
                } else {
                    this.a.h.post(new a(this, measuredWidth, width2, width3, width4, d0));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ ty7 b;
        public final /* synthetic */ hx7 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ g b;

            public a(g gVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.b;
                    gVar.b.b.a(gVar.c.l, null, this.a, gVar.a.q.getLayoutStrategy());
                }
            }
        }

        public g(hx7 hx7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, ty7 ty7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbTopCommenFloorItemViewHolder, ty7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hx7Var;
            this.a = pbTopCommenFloorItemViewHolder;
            this.b = ty7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f092005) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f092005)) == null || this.a.b == null || this.b == null) {
                    return;
                }
                rg.a().postDelayed(new a(this, postData), 100L);
                String Q = this.c.l.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.l.Q())) && this.c.l.O() != null) {
                    Q = this.c.l.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.K()).param("obj_source", this.c.f0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder a;
        public final /* synthetic */ hx7 b;

        public h(hx7 hx7Var, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = hx7Var;
            this.a = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.l == null || (pbTopCommenFloorItemViewHolder = this.a) == null || (agreeView = pbTopCommenFloorItemViewHolder.Y) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.Y.getImgAgree() ? 1 : 2;
            String Q = this.b.l.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                Q = this.b.l.O().getNid();
            }
            i08.o(this.a.Y.getData().hasAgree ? 3 : 4);
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.Y.getData().postId).param("obj_source", this.b.f0(this.a.Y)).param("obj_type", i));
        }
    }

    /* loaded from: classes6.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbTopCommenFloorItemViewHolder b;
        public final /* synthetic */ hx7 c;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ i a;

            /* renamed from: com.repackage.hx7$i$a$a  reason: collision with other inner class name */
            /* loaded from: classes6.dex */
            public class View$OnClickListenerC0496a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0496a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                        i08.p("c14886");
                        i iVar = this.a.a;
                        hx7 hx7Var = iVar.c;
                        hx7Var.h0(((PostData) hx7Var.getItem(iVar.a)).s());
                    }
                }
            }

            /* loaded from: classes6.dex */
            public class b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public b(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        i iVar = this.a.a;
                        ((PostData) iVar.c.getItem(iVar.a)).x0();
                        i iVar2 = this.a.a;
                        if (((PostData) iVar2.c.getItem(iVar2.a)).U() <= 0) {
                            i iVar3 = this.a.a;
                            ((PostData) iVar3.c.getItem(iVar3.a)).N0(Boolean.FALSE);
                            this.a.a.b.l0.setVisibility(8);
                            this.a.a.b.Y.setVisibility(0);
                        }
                    }
                }
            }

            public a(i iVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = iVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.Y.getAgreeFlag()) {
                    i iVar = this.a;
                    ((PostData) iVar.c.getItem(iVar.a)).w0();
                    i iVar2 = this.a;
                    ((PostData) iVar2.c.getItem(iVar2.a)).N0(Boolean.TRUE);
                    this.a.b.Y.setVisibility(8);
                    this.a.b.l0.setVisibility(0);
                    this.a.b.l0.setOnClickListener(new View$OnClickListenerC0496a(this));
                    this.a.b.l0.postDelayed(new b(this), 5000L);
                }
            }
        }

        public i(hx7 hx7Var, int i, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hx7Var, Integer.valueOf(i), pbTopCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = hx7Var;
            this.a = i;
            this.b = pbTopCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && UtilHelper.isCurrentAccount(this.c.l.O().getAuthor().getUserId()) && this.c.l.O().isQuestionThread() && !UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                if (this.b.Y.getAgreeFlag()) {
                    ((PostData) this.c.getItem(this.a)).O0(1);
                    this.b.k0.setVisibility(0);
                    ((PostData) this.c.getItem(this.a)).H0(true);
                    this.b.i.setVisibility(8);
                    this.b.Y.postDelayed(new a(this), 900L);
                    return;
                }
                ((PostData) this.c.getItem(this.a)).O0(0);
                this.b.l0.setVisibility(8);
                this.b.k0.setVisibility(8);
                this.b.Y.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).H0(false);
                if (((PostData) this.c.getItem(this.a)).W().booleanValue()) {
                    this.b.i.setVisibility(0);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hx7(t08 t08Var, BdUniqueId bdUniqueId) {
        super(t08Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {t08Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((t08) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = 0;
        this.h = null;
        this.i = true;
        this.j = 1.0f;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = true;
        this.s = false;
        this.t = 0;
        this.u = null;
        this.v = new fg<>(new a(this), 6, 0);
        this.w = new fg<>(new b(this), 12, 0);
        this.x = new hu7(new c(this));
        if (t08Var != null && t08Var.K() != null) {
            this.r = t08Var.K().P1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void E(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbTopCommenFloorItemViewHolder) == null) {
            pbTopCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.o);
            pbTopCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
        }
    }

    public final void F(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.K());
                statisticItem.param("pid", postData.K());
                statisticItem.param("tid", postData.d0());
                statisticItem.param("fid", postData.G());
                statisticItem.param("fname", postData.H());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            ft7 ft7Var = this.l;
            if (ft7Var != null) {
                if (ft7Var.u0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.c;
                    if (absVideoPbFragment != null) {
                        i08.e(absVideoPbFragment.getUniqueId(), this.l, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.b;
                if (pbFragment != null) {
                    i08.e(pbFragment.getUniqueId(), this.l, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                }
            }
        }
    }

    public final void G(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, postData) == null) && postData.C == 0 && postData.K) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.K());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            t08 t08Var = this.a;
            if (t08Var != null) {
                int P1 = t08Var.K().P1();
                if (1 == P1 || 2 == P1) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == P1) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() == null || postData.s().getAlaInfo() == null || postData.s().getAlaInfo().live_status != 1) {
                return;
            }
            l0(postData);
        }
    }

    public final void H(PostData postData, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, postData, pbTopCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.l0() + postData.L()) {
                if (pbTopCommenFloorItemViewHolder.I != null && postData.s() != null) {
                    pbTopCommenFloorItemViewHolder.I.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
                    t08 t08Var = this.a;
                    if (t08Var != null && t08Var.P() != null) {
                        pbTopCommenFloorItemViewHolder.I.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                    int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbTopCommenFloorItemViewHolder.I.g(iconInfo, i3, f2, f2, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.W().booleanValue() && !postData.J()) {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(8);
                }
            } else if (i2 > postData.L()) {
                if (postData.W().booleanValue() && !postData.J()) {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.i.setVisibility(8);
                }
            } else {
                pbTopCommenFloorItemViewHolder.I.setVisibility(8);
                pbTopCommenFloorItemViewHolder.i.setVisibility(8);
            }
        }
    }

    public final void J(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, tbRichTextView, view2, z) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k = (((qi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int s = z ? s(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k - s) * this.j));
        tbRichTextView.getLayoutStrategy().H = (k - s) - s(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f * this.j));
    }

    public final void K(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbTopCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbTopCommenFloorItemViewHolder.Q.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbTopCommenFloorItemViewHolder.S.setText(R.string.obfuscated_res_0x7f0f05d8);
                    return;
                } else {
                    pbTopCommenFloorItemViewHolder.S.setText(str);
                    return;
                }
            }
            pbTopCommenFloorItemViewHolder.Q.setVisibility(0);
            pbTopCommenFloorItemViewHolder.S.setText(R.string.obfuscated_res_0x7f0f03f6);
        }
    }

    public final void L(boolean z, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbTopCommenFloorItemViewHolder, postData}) == null) || pbTopCommenFloorItemViewHolder == null || (linearLayout = pbTopCommenFloorItemViewHolder.R) == null || !(linearLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Y());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbTopCommenFloorItemViewHolder.R.getLayoutParams();
        if (z) {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().m(0);
            if (z2) {
                pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams != null) {
                    layoutParams.topMargin = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                }
            }
            pbTopCommenFloorItemViewHolder.R.setLayoutParams(layoutParams);
            return;
        }
        pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().m(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
    }

    public final boolean M(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, postData)) == null) {
            if (this.l.O() == null || this.l.O().getAuthor() == null || this.l.O().getAuthor().getUserId() == null || postData == null || postData.s() == null || postData.s().getUserId() == null) {
                return false;
            }
            return this.l.O().getAuthor().getUserId().equals(postData.s().getUserId());
        }
        return invokeL.booleanValue;
    }

    public final void N(View view2) {
        PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbTopCommenFloorItemViewHolder) || (agreeView = (pbTopCommenFloorItemViewHolder = (PbTopCommenFloorItemViewHolder) view2.getTag()).Y) == null || agreeView.getData() == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.Y.setAgreeSource(2);
        pbTopCommenFloorItemViewHolder.Y.I();
    }

    public final void O(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, postData) == null) {
            if (postData != null) {
                StatisticItem i2 = i08.i(this.l, postData, postData.b0, postData.a0 ? 2 : 8, 6);
                postData.c0 = i2;
                if (!ListUtils.isEmpty(postData.Y())) {
                    Iterator<PostData> it = postData.Y().iterator();
                    while (it.hasNext()) {
                        it.next().c0 = i2;
                    }
                }
            }
            i08.p("c14887");
        }
    }

    public final void P(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.i && !d0()) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.q.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbTopCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
                pbTopCommenFloorItemViewHolder.q.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.q.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbTopCommenFloorItemViewHolder.q.setLayoutParams(layoutParams2);
                pbTopCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
                pbTopCommenFloorItemViewHolder.q.k0(null);
            }
            pbTopCommenFloorItemViewHolder.q.setTextViewOnTouchListener(this.x);
            pbTopCommenFloorItemViewHolder.q.setTextViewCheckSelection(false);
        }
    }

    public final void Q(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null || (imageView = pbTopCommenFloorItemViewHolder.J) == null || this.l == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void R(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        ft7 ft7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z2 = true;
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z = true;
                j15 R = postData.R();
                z2 = (R != null || StringUtils.isNull(R.b()) || (ft7Var = this.l) == null || ft7Var.i0()) ? false : false;
                pbTopCommenFloorItemViewHolder.l.setVisibility(8);
                if (z2 && !z) {
                    pbTopCommenFloorItemViewHolder.m.setVisibility(8);
                    i2 = 0;
                } else {
                    pbTopCommenFloorItemViewHolder.m.setVisibility(0);
                    i2 = this.g;
                }
                pbTopCommenFloorItemViewHolder.k.setPadding(0, 0, i2, 0);
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
                    pbTopCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTimeShort(postData.e0()));
                } else {
                    pbTopCommenFloorItemViewHolder.k.setText(StringHelper.getFormatTime(postData.e0()));
                }
                if (!z) {
                    pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                    TextView textView = pbTopCommenFloorItemViewHolder.n;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14e4) + str);
                } else if (z2) {
                    pbTopCommenFloorItemViewHolder.n.setVisibility(0);
                    pbTopCommenFloorItemViewHolder.n.setPadding(this.g, 0, 0, 0);
                    if (postData.Z) {
                        pbTopCommenFloorItemViewHolder.n.setText(StringHelper.cutStringWithSuffix(R.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbTopCommenFloorItemViewHolder.n.setText(R.b());
                    }
                } else {
                    pbTopCommenFloorItemViewHolder.n.setVisibility(8);
                }
                TextView textView2 = pbTopCommenFloorItemViewHolder.b0;
                textView2.setText(((Object) pbTopCommenFloorItemViewHolder.k.getText()) + "  • ");
            }
        }
        z = false;
        j15 R2 = postData.R();
        if (R2 != null) {
        }
        pbTopCommenFloorItemViewHolder.l.setVisibility(8);
        if (z2) {
        }
        pbTopCommenFloorItemViewHolder.m.setVisibility(0);
        i2 = this.g;
        pbTopCommenFloorItemViewHolder.k.setPadding(0, 0, i2, 0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
        }
        if (!z) {
        }
        TextView textView22 = pbTopCommenFloorItemViewHolder.b0;
        textView22.setText(((Object) pbTopCommenFloorItemViewHolder.k.getText()) + "  • ");
    }

    public final void S(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.V.setVisibility(postData.Z ? 0 : 8);
    }

    public final void T(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048590, this, pbTopCommenFloorItemViewHolder, postData, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.s.setVisibility(8);
        pbTopCommenFloorItemViewHolder.X.setVisibility(0);
        pbTopCommenFloorItemViewHolder.a0.setVisibility(8);
        c0(pbTopCommenFloorItemViewHolder, postData, view2, i2);
        Q(pbTopCommenFloorItemViewHolder, postData);
        U(pbTopCommenFloorItemViewHolder, postData);
        X(pbTopCommenFloorItemViewHolder, postData, view2);
        R(pbTopCommenFloorItemViewHolder, postData);
        Z(pbTopCommenFloorItemViewHolder, postData);
        V(pbTopCommenFloorItemViewHolder, postData);
        a0(pbTopCommenFloorItemViewHolder, postData);
        P(pbTopCommenFloorItemViewHolder, postData);
        S(pbTopCommenFloorItemViewHolder, postData);
        Y(pbTopCommenFloorItemViewHolder, postData);
        b0(pbTopCommenFloorItemViewHolder, postData);
        q0(pbTopCommenFloorItemViewHolder, postData);
        W(pbTopCommenFloorItemViewHolder, postData);
    }

    public final void U(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.a.K().i2();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        ThreadData threadData = null;
        ft7 ft7Var = this.l;
        if (ft7Var != null && ft7Var.O() != null) {
            threadData = this.l.O();
        }
        pbTopCommenFloorItemViewHolder.Y.setThreadData(threadData);
        pbTopCommenFloorItemViewHolder.Y.setData(postData.q());
    }

    public final void V(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || pbTopCommenFloorItemViewHolder.O == null || pbTopCommenFloorItemViewHolder.L == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.R) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbTopCommenFloorItemViewHolder.O.setText(postData.R.liveTitle);
            pbTopCommenFloorItemViewHolder.L.setTag(postData.R);
            pbTopCommenFloorItemViewHolder.L.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbTopCommenFloorItemViewHolder.L.setVisibility(8);
    }

    public final void W(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData.a0() != 0) {
                pbTopCommenFloorItemViewHolder.o.setVisibility(0);
                TextView textView = pbTopCommenFloorItemViewHolder.o;
                textView.setText("查看全部" + postData.a0() + "条数据");
                return;
            }
            pbTopCommenFloorItemViewHolder.o.setVisibility(8);
        }
    }

    public final void X(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, pbTopCommenFloorItemViewHolder, postData, view2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbTopCommenFloorItemViewHolder.q.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = qi.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.leftMargin = qi.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbTopCommenFloorItemViewHolder.q.setPadding(0, 0, 0, 0);
        if (!this.i) {
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbTopCommenFloorItemViewHolder.q.k0(null);
            pbTopCommenFloorItemViewHolder.q.setBackgroundDrawable(null);
            pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08120f);
        }
        pbTopCommenFloorItemViewHolder.q.getLayoutStrategy().x(R.drawable.pic_video);
        J(pbTopCommenFloorItemViewHolder.q, view2, !StringUtils.isNull(postData.t()));
        pbTopCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
        pbTopCommenFloorItemViewHolder.q.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbTopCommenFloorItemViewHolder.q.setIsFromCDN(this.e);
        pbTopCommenFloorItemViewHolder.q.setText(postData.V(), true, this.h);
        SparseArray sparseArray = (SparseArray) pbTopCommenFloorItemViewHolder.q.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.TRUE);
        pbTopCommenFloorItemViewHolder.q.setTag(sparseArray);
        pbTopCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091ffb, sparseArray);
        pbTopCommenFloorItemViewHolder.Z.setTag(sparseArray);
    }

    public final void Y(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || pbTopCommenFloorItemViewHolder.b == null) {
            return;
        }
        t08 t08Var = this.a;
        if (t08Var != null && t08Var.K() != null && StringHelper.equals(this.a.K().r1(), postData.K())) {
            SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public final void Z(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.b0() != null && !d0()) {
                TbRichText V = postData.V();
                v18.c(postData.b0(), pbTopCommenFloorItemViewHolder.K, false, true, V != null && StringUtils.isNull(V.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbTopCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void a0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            if (postData.F() != 2 && postData.F() != 4) {
                pbTopCommenFloorItemViewHolder.R.setVisibility(8);
                pbTopCommenFloorItemViewHolder.Q.setVisibility(0);
                L(false, pbTopCommenFloorItemViewHolder, postData);
            } else {
                pbTopCommenFloorItemViewHolder.R.setOnClickListener(new d(this, pbTopCommenFloorItemViewHolder, postData));
                pbTopCommenFloorItemViewHolder.R.setVisibility(0);
                K(pbTopCommenFloorItemViewHolder, postData.q0(), postData.E());
                L(true, pbTopCommenFloorItemViewHolder, postData);
            }
            k0(pbTopCommenFloorItemViewHolder, postData);
        }
    }

    public final void b0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, pbTopCommenFloorItemViewHolder, postData) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbTopCommenFloorItemViewHolder.e(postData.Q, postData.K(), this.s);
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.i = z;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:283:0x0803  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0807  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0819  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x085c  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0863  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x08cc  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0918  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        int i4;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048600, this, pbTopCommenFloorItemViewHolder, postData, view2, i2) == null) || pbTopCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(pbTopCommenFloorItemViewHolder.d, R.color.CAM_X0204);
        pbTopCommenFloorItemViewHolder.d.setVisibility(0);
        pbTopCommenFloorItemViewHolder.p.setTag(null);
        pbTopCommenFloorItemViewHolder.p.setUserId(null);
        pbTopCommenFloorItemViewHolder.G.getHeadView().setUserId(null);
        pbTopCommenFloorItemViewHolder.q.setIsHost(false);
        if (postData.s() != null) {
            String str = this.k;
            if (str != null && !str.equals("0") && this.k.equals(postData.s().getUserId())) {
                pbTopCommenFloorItemViewHolder.q.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            int f3 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
            if (iconInfo.size() < 2) {
                i3 = iconInfo.size();
                if (i3 > 1) {
                    postData.d1((f2 * i3) + (f3 * i3));
                } else if (i3 == 1) {
                    postData.d1(f2 + f3);
                } else {
                    postData.d1(0);
                }
            } else {
                postData.d1((f2 * 2) + (f3 * 2));
                i3 = 2;
            }
            if (pbTopCommenFloorItemViewHolder.H != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbTopCommenFloorItemViewHolder.H.setTag(tShowInfoNew.get(0).getUrl());
                }
                t08 t08Var = this.a;
                if (t08Var != null && t08Var.P() != null) {
                    pbTopCommenFloorItemViewHolder.H.setOnClickListener(this.a.P().d.e);
                }
                int f4 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbTopCommenFloorItemViewHolder.H.h(tShowInfoNew, 3, f4, f4, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lx7.n(pbTopCommenFloorItemViewHolder.g);
                    } else {
                        ms4.d(pbTopCommenFloorItemViewHolder.g).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i5 = postData.a0 ? 2 : 8;
            pbTopCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092018, postData);
            pbTopCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092002, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092002, Boolean.TRUE);
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092045, postData.s().getUserName());
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getVirtualUserUrl());
            pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092033, i08.i(this.l, postData, postData.b0, i5, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbTopCommenFloorItemViewHolder.h.setText(gs7.b(this.mContext, pbTopCommenFloorItemViewHolder.g.getText().toString()));
                pbTopCommenFloorItemViewHolder.g.setGravity(16);
                pbTopCommenFloorItemViewHolder.g.setTag(R.id.obfuscated_res_0x7f092012, gs7.a());
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbTopCommenFloorItemViewHolder.G.setBigVDimenSize(R.dimen.tbds36);
                pbTopCommenFloorItemViewHolder.G.j(postData.s(), 4);
                pbTopCommenFloorItemViewHolder.p.setVisibility(8);
                pbTopCommenFloorItemViewHolder.G.setVisibility(0);
                pbTopCommenFloorItemViewHolder.G.getHeadView().K(avater, 28, false);
                pbTopCommenFloorItemViewHolder.G.getHeadView().setUserId(postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.G.getHeadView().setUserName(postData.s().getUserName());
                ft7 ft7Var = this.l;
                pbTopCommenFloorItemViewHolder.G.getHeadView().setFid(ft7Var != null ? ft7Var.m() : "");
                ft7 ft7Var2 = this.l;
                pbTopCommenFloorItemViewHolder.G.getHeadView().setFName(ft7Var2 != null ? ft7Var2.n() : "");
                pbTopCommenFloorItemViewHolder.G.getHeadView().setFloor(postData.B());
                pbTopCommenFloorItemViewHolder.G.getHeadView().setTid(postData.K());
                pbTopCommenFloorItemViewHolder.G.getHeadView().setTag(R.id.obfuscated_res_0x7f092033, i08.i(this.l, postData, postData.b0, i5, 2));
                pbTopCommenFloorItemViewHolder.G.setTag(R.id.obfuscated_res_0x7f092002, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.G.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbTopCommenFloorItemViewHolder.p.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbTopCommenFloorItemViewHolder.p, postData.s(), 4);
                pbTopCommenFloorItemViewHolder.p.setUserId(postData.s().getUserId());
                ft7 ft7Var3 = this.l;
                pbTopCommenFloorItemViewHolder.p.setFid(ft7Var3 != null ? ft7Var3.m() : "");
                ft7 ft7Var4 = this.l;
                pbTopCommenFloorItemViewHolder.p.setFName(ft7Var4 != null ? ft7Var4.n() : "");
                pbTopCommenFloorItemViewHolder.p.setFloor(postData.B());
                pbTopCommenFloorItemViewHolder.p.setTid(postData.K());
                pbTopCommenFloorItemViewHolder.p.setUserName(postData.s().getUserName(), postData.g0());
                pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getVirtualUserUrl());
                pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f092002, Boolean.TRUE);
                pbTopCommenFloorItemViewHolder.p.setTag(R.id.obfuscated_res_0x7f092033, i08.i(this.l, postData, postData.b0, i5, 2));
                pbTopCommenFloorItemViewHolder.p.setImageDrawable(null);
                pbTopCommenFloorItemViewHolder.p.K(avater, 28, false);
                pbTopCommenFloorItemViewHolder.p.setVisibility(0);
                pbTopCommenFloorItemViewHolder.G.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbTopCommenFloorItemViewHolder.d(true);
                pbTopCommenFloorItemViewHolder.p.setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.p.setAlaInfo(postData.s().getAlaInfo());
                pbTopCommenFloorItemViewHolder.G.getHeadView().setLiveStatus(1);
                pbTopCommenFloorItemViewHolder.G.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbTopCommenFloorItemViewHolder.d(false);
                pbTopCommenFloorItemViewHolder.p.setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.p.setAlaInfo(null);
                pbTopCommenFloorItemViewHolder.G.getHeadView().setLiveStatus(0);
                pbTopCommenFloorItemViewHolder.G.getHeadView().setAlaInfo(null);
            }
            s0(pbTopCommenFloorItemViewHolder.i, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 > 0 && a2 <= 10) {
                    pbTopCommenFloorItemViewHolder.j.K(String.valueOf(vw.b(a2)), 24, false);
                    pbTopCommenFloorItemViewHolder.j.setVisibility(0);
                } else {
                    pbTopCommenFloorItemViewHolder.j.setVisibility(8);
                }
            }
        } else {
            i3 = 2;
        }
        t08 t08Var2 = this.a;
        int level_id = (t08Var2 == null || t08Var2.P() == null || !this.a.P().u0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        ft7 ft7Var5 = this.l;
        if (ft7Var5 != null && ft7Var5.i0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbTopCommenFloorItemViewHolder.F.setVisibility(0);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.F, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbTopCommenFloorItemViewHolder.F.setVisibility(8);
        }
        int i6 = 15;
        if (i3 == 1) {
            i6 = 13;
        } else if (i3 > 1) {
            i6 = 11;
        }
        if (pbTopCommenFloorItemViewHolder.i.getVisibility() == 0) {
            i6 -= 2;
        }
        if (pbTopCommenFloorItemViewHolder.H.getChildCount() > 0) {
            i6 -= 2;
        }
        if (postData.x() > 1000) {
            i6 -= 2;
        }
        if (postData.x() > 10) {
            i6 -= 2;
        }
        if (i6 < 10) {
            if (i3 == 1) {
                i6 += 2;
            } else if (i3 > 1) {
                i6 += 4;
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.i.getVisibility() == 0) {
                i6 += 2;
                pbTopCommenFloorItemViewHolder.i.setVisibility(8);
            }
            if (i6 < 10 && pbTopCommenFloorItemViewHolder.F.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.F.setVisibility(8);
            }
        }
        int e2 = lx7.e();
        String name_show2 = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = if5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i7 = e2 - 2;
            if (d2 > i7) {
                name_show2 = if5.n(name_show2, i7) + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            name_show2 = if5.n(name_show2, e2) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbTopCommenFloorItemViewHolder.h.setText(e0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbTopCommenFloorItemViewHolder.h.setText(name_show2);
        }
        if (((PostData) getItem(i2)).N() == 1 && this.l.O() != null && this.l.O().isQuestionThread() && !M(postData)) {
            ((PostData) getItem(i2)).H0(true);
            pbTopCommenFloorItemViewHolder.k0.setVisibility(0);
            if (((PostData) getItem(i2)).M().booleanValue()) {
                pbTopCommenFloorItemViewHolder.l0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.Y.setVisibility(8);
                pbTopCommenFloorItemViewHolder.l0.postDelayed(new e(this, pbTopCommenFloorItemViewHolder), 3000L);
            } else {
                pbTopCommenFloorItemViewHolder.l0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.Y.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).H0(false);
            pbTopCommenFloorItemViewHolder.k0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.l0.setVisibility(8);
            pbTopCommenFloorItemViewHolder.Y.setVisibility(0);
        }
        ImageView imageView = pbTopCommenFloorItemViewHolder.y;
        if (imageView != null) {
            SparseArray sparseArray = (SparseArray) imageView.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbTopCommenFloorItemViewHolder.y.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092005, postData);
        }
        ImageView imageView2 = pbTopCommenFloorItemViewHolder.z;
        if (imageView2 != null) {
            SparseArray sparseArray2 = (SparseArray) imageView2.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbTopCommenFloorItemViewHolder.z.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f092005, postData);
        }
        SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.k0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.o0, R.color.CAM_X0105, 1);
        pbTopCommenFloorItemViewHolder.f.post(new f(this, pbTopCommenFloorItemViewHolder, new String[]{name_show2}, postData, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.m0.setVisibility(0);
            pbTopCommenFloorItemViewHolder.m0.setText(postData.s().getDiplayIntro() + "");
        } else {
            i4 = 0;
            pbTopCommenFloorItemViewHolder.m0.setVisibility(8);
        }
        SparseArray sparseArray3 = new SparseArray();
        sparseArray3.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray3.put(R.id.obfuscated_res_0x7f092005, postData);
        sparseArray3.put(R.id.obfuscated_res_0x7f092007, view2);
        sparseArray3.put(R.id.obfuscated_res_0x7f092016, Integer.valueOf(i2));
        sparseArray3.put(R.id.obfuscated_res_0x7f092015, Integer.valueOf(postData.B()));
        sparseArray3.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
        sparseArray3.put(R.id.obfuscated_res_0x7f0917b9, pbTopCommenFloorItemViewHolder.Y);
        sparseArray3.put(R.id.obfuscated_res_0x7f0917b6, pbTopCommenFloorItemViewHolder.y);
        sparseArray3.put(R.id.obfuscated_res_0x7f0917b7, pbTopCommenFloorItemViewHolder.z);
        ft7 ft7Var6 = this.l;
        ThreadData O = (ft7Var6 == null || ft7Var6.O() == null) ? null : this.l.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray3.put(R.id.obfuscated_res_0x7f0917b5, Boolean.TRUE);
        } else {
            sparseArray3.put(R.id.obfuscated_res_0x7f0917b5, Boolean.FALSE);
        }
        boolean z7 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        ft7 ft7Var7 = this.l;
        if (ft7Var7 == null || ft7Var7.W() == 0 || g0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.l.W() == 1002 || this.l.W() == 3) ? false : true;
            z2 = (this.l.W() == 3 || this.l.i0()) ? false : true;
            if (postData != null && postData.s() != null) {
                String userId = postData.s().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        ft7 ft7Var8 = this.l;
        if (ft7Var8 != null && ft7Var8.O() != null && this.l.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.l.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z2 = true;
                    z3 = false;
                    z4 = true;
                } else {
                    z2 = true;
                    z3 = true;
                    z4 = false;
                }
                z5 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z2 = true;
                    z4 = true;
                }
                if (z7) {
                    z6 = z;
                } else {
                    z2 = false;
                    z3 = false;
                    z6 = false;
                }
                if (postData.B() != 1) {
                    i4 = 1;
                }
                if (!z6) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(this.l.W()));
                    if (postData.s() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f091ff5, postData.s().getUserName());
                        sparseArray3.put(R.id.obfuscated_res_0x7f091ff6, postData.s().getName_show());
                        sparseArray3.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getPortrait());
                    }
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fff, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f092040, postData.s().getUserId());
                        sparseArray3.put(R.id.obfuscated_res_0x7f092041, postData.s().getUserName());
                        sparseArray3.put(R.id.obfuscated_res_0x7f09203f, postData.s().getName_show());
                    }
                    if (this.l.O() != null) {
                        sparseArray3.put(R.id.obfuscated_res_0x7f092043, this.l.O().getId());
                    }
                    sparseArray3.put(R.id.obfuscated_res_0x7f092042, postData.K());
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                }
                if (!z2) {
                    sparseArray3.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                    sparseArray3.put(R.id.obfuscated_res_0x7f091ffc, Boolean.valueOf(postData.n0()));
                    sparseArray3.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(this.l.W()));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z4));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i4));
                    sparseArray3.put(R.id.obfuscated_res_0x7f091fea, postData.K());
                } else {
                    sparseArray3.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z5));
                pbTopCommenFloorItemViewHolder.q.setTag(sparseArray3);
            }
        }
        z3 = false;
        z4 = false;
        z5 = false;
        if (postData != null) {
            z2 = true;
            z4 = true;
        }
        if (z7) {
        }
        if (postData.B() != 1) {
        }
        if (!z6) {
        }
        if (!z3) {
        }
        if (!z2) {
        }
        sparseArray3.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z5));
        pbTopCommenFloorItemViewHolder.q.setTag(sparseArray3);
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onLongClickListener) == null) {
            this.p = onLongClickListener;
        }
    }

    public final boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            ft7 ft7Var = this.l;
            if (ft7Var == null || ft7Var.O() == null) {
                return true;
            }
            return this.l.O().isQuestionThread();
        }
        return invokeV.booleanValue;
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public final SpannableStringBuilder e0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048604, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new mz5.a(str, R.drawable.pic_smalldot_title));
            return mz5.h(this.a.P(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String f0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f091852);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f091852);
            view2.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ft7 ft7Var = this.l;
            if (ft7Var == null || ft7Var.O() == null) {
                return false;
            }
            return this.l.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    public void h0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: i0 */
    public PbTopCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06cb, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091834)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06c2, (ViewGroup) null));
            PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder = new PbTopCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.r);
            pbTopCommenFloorItemViewHolder.r.setConstrainLayoutPool(this.v);
            pbTopCommenFloorItemViewHolder.r.setImageViewPool(this.w);
            p0(pbTopCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbTopCommenFloorItemViewHolder.q;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.q);
            }
            return pbTopCommenFloorItemViewHolder;
        }
        return (PbTopCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View j0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbTopCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbTopCommenFloorItemViewHolder);
            p0(pbTopCommenFloorItemViewHolder);
            m0(pbTopCommenFloorItemViewHolder, i2);
            E(pbTopCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.b0 = i2 + 1;
                G(postData2);
                F(postData2);
                postData2.h1();
                O(postData2);
                T(pbTopCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
        }
    }

    public final void k0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            TbRichText V = postData.V();
            V.isChanged = true;
            pbTopCommenFloorItemViewHolder.q.setText(V, true, this.h);
        }
    }

    public final void l0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, postData) == null) {
            String userId = postData.s().getUserId();
            ft7 ft7Var = this.l;
            String m = ft7Var != null ? ft7Var.m() : "";
            ft7 ft7Var2 = this.l;
            String n = ft7Var2 != null ? ft7Var2.n() : "";
            int B = postData.B();
            String K = postData.K();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", m);
            statisticItem.param("fname", n);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", K);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, B);
            if (postData.s().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.s().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void m0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048613, this, pbTopCommenFloorItemViewHolder, i2) == null) {
            pbTopCommenFloorItemViewHolder.b.setOnTouchListener(this.x);
            pbTopCommenFloorItemViewHolder.b.setOnLongClickListener(this.p);
            if (this.a.P() == null || this.a.P().getPageContext() == null || this.a.P().getPageContext().getOrignalPage() == null) {
                return;
            }
            ry7 ry7Var = this.a.P().d;
            pbTopCommenFloorItemViewHolder.g.setOnClickListener(ry7Var.b);
            pbTopCommenFloorItemViewHolder.p.setOnClickListener(ry7Var.b);
            pbTopCommenFloorItemViewHolder.h0.setOnClickListener(ry7Var.d);
            pbTopCommenFloorItemViewHolder.g0.setOnClickListener(ry7Var.d);
            pbTopCommenFloorItemViewHolder.G.setOnClickListener(ry7Var.b);
            pbTopCommenFloorItemViewHolder.G.getHeadView().setOnClickListener(ry7Var.b);
            pbTopCommenFloorItemViewHolder.q.setOnLongClickListener(this.p);
            pbTopCommenFloorItemViewHolder.q.setOnTouchListener(this.x);
            pbTopCommenFloorItemViewHolder.q.setCommonTextViewOnClickListener(this.m);
            pbTopCommenFloorItemViewHolder.q.setOnImageClickListener(this.n);
            pbTopCommenFloorItemViewHolder.q.setOnImageTouchListener(this.x);
            pbTopCommenFloorItemViewHolder.q.setOnEmotionClickListener(ry7Var.f);
            pbTopCommenFloorItemViewHolder.q.setOnVoiceAfterClickListener(this.m);
            pbTopCommenFloorItemViewHolder.K.setOnClickListener(this.m);
            pbTopCommenFloorItemViewHolder.L.setOnClickListener(this.m);
            pbTopCommenFloorItemViewHolder.o.setOnClickListener(this.m);
            pbTopCommenFloorItemViewHolder.Z.setOnClickListener(this.m);
            ty7 ty7Var = this.a.P().e;
            pbTopCommenFloorItemViewHolder.y.setOnClickListener(this.m);
            pbTopCommenFloorItemViewHolder.z.setOnClickListener(new g(this, pbTopCommenFloorItemViewHolder, ty7Var));
            pbTopCommenFloorItemViewHolder.Y.x = new h(this, pbTopCommenFloorItemViewHolder);
            pbTopCommenFloorItemViewHolder.Y.setAfterClickListener(new i(this, i2, pbTopCommenFloorItemViewHolder));
        }
    }

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, yVar) == null) {
            this.n = yVar;
        }
    }

    public void n0(hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, hu7Var) == null) {
            this.o = hu7Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
            this.k = str;
        }
    }

    public void o0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, sVar) == null) {
            this.h = sVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, view2) == null) {
        }
    }

    @Override // com.repackage.bw7, com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        j0(i2, view2, viewGroup, (PostData) obj, (PbTopCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void p0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, pbTopCommenFloorItemViewHolder) == null) || pbTopCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbTopCommenFloorItemViewHolder.a != skinType) {
            r0(pbTopCommenFloorItemViewHolder.i);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lx7.n(pbTopCommenFloorItemViewHolder.g);
                } else {
                    ms4.d(pbTopCommenFloorItemViewHolder.g).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.g, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.m, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.n0, R.color.CAM_X0105, 1);
            pbTopCommenFloorItemViewHolder.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.b0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.c0, R.color.CAM_X0107, 1);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.getColor(R.color.CAM_X0304);
            pbTopCommenFloorItemViewHolder.r.b();
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.O, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.M, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.L, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbTopCommenFloorItemViewHolder.N, R.color.CAM_X0109);
            SkinManager.setImageResource(pbTopCommenFloorItemViewHolder.P, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbTopCommenFloorItemViewHolder.S, (int) R.color.CAM_X0107);
            if (pbTopCommenFloorItemViewHolder.Q.getVisibility() == 8) {
                pbTopCommenFloorItemViewHolder.S.setText(R.string.obfuscated_res_0x7f0f03f6);
            } else {
                ft7 ft7Var = this.l;
                if (ft7Var != null && StringUtils.isNull(ft7Var.k())) {
                    pbTopCommenFloorItemViewHolder.S.setText(this.l.k());
                } else {
                    pbTopCommenFloorItemViewHolder.S.setText(R.string.obfuscated_res_0x7f0f05d8);
                }
            }
            pbTopCommenFloorItemViewHolder.c(skinType);
            WebPManager.setPureDrawable(pbTopCommenFloorItemViewHolder.Z, R.drawable.obfuscated_res_0x7f080965, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbTopCommenFloorItemViewHolder.b();
        }
        pbTopCommenFloorItemViewHolder.a = skinType;
    }

    public void q0(PbTopCommenFloorItemViewHolder pbTopCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, pbTopCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.i0() != null) {
                VirtualImageCustomFigure i0 = postData.i0();
                pbTopCommenFloorItemViewHolder.h0.setHeadImageViewResource(i0.getFigureUrl());
                pbTopCommenFloorItemViewHolder.h0.setTid(postData.K());
                pbTopCommenFloorItemViewHolder.h0.setLocate(px7.c);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(i0.getBackGroundType())) {
                    str = i0.getBackgroundValue();
                    pbTopCommenFloorItemViewHolder.h0.setHeadImageBackgroundColorResource(i0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(i0.getBackGroundType())) {
                    pbTopCommenFloorItemViewHolder.h0.setHeadImageBackgroundResource(i0.getBackgroundValue());
                }
                pbTopCommenFloorItemViewHolder.h0.d(postData.s());
                pbTopCommenFloorItemViewHolder.f0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.i0.setVisibility(0);
                pbTopCommenFloorItemViewHolder.h0.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.h0.setTag(R.id.obfuscated_res_0x7f092045, postData.s().getUserName());
            } else {
                pbTopCommenFloorItemViewHolder.i0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.h0.setTag(R.id.obfuscated_res_0x7f09203d, null);
                pbTopCommenFloorItemViewHolder.h0.setTag(R.id.obfuscated_res_0x7f092045, null);
                pbTopCommenFloorItemViewHolder.f0.setVisibility(0);
            }
            if (postData.j0() != null && !TextUtils.isEmpty(postData.j0().b())) {
                pbTopCommenFloorItemViewHolder.g0.setData(postData.j0().b(), null, str);
                pbTopCommenFloorItemViewHolder.g0.setVisibility(0);
                if (pbTopCommenFloorItemViewHolder.j0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.j0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbTopCommenFloorItemViewHolder.j0.setLayoutParams(marginLayoutParams);
                }
                pbTopCommenFloorItemViewHolder.g0.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
                pbTopCommenFloorItemViewHolder.g0.setTag(R.id.obfuscated_res_0x7f092045, postData.s().getUserName());
                this.t = px7.d;
                this.u = pbTopCommenFloorItemViewHolder.g0.getData();
                pbTopCommenFloorItemViewHolder.h0.setWithBubble(this.t);
                pbTopCommenFloorItemViewHolder.h0.setBubbleName(this.u);
            } else {
                if (pbTopCommenFloorItemViewHolder.j0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbTopCommenFloorItemViewHolder.j0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbTopCommenFloorItemViewHolder.j0.setLayoutParams(marginLayoutParams2);
                }
                pbTopCommenFloorItemViewHolder.g0.setVisibility(8);
                pbTopCommenFloorItemViewHolder.g0.setTag(R.id.obfuscated_res_0x7f092045, null);
                pbTopCommenFloorItemViewHolder.g0.setTag(R.id.obfuscated_res_0x7f09203d, null);
                int i2 = px7.e;
                this.t = i2;
                pbTopCommenFloorItemViewHolder.h0.setWithBubble(i2);
            }
            if (pbTopCommenFloorItemViewHolder.h0.getVisibility() == 0) {
                pbTopCommenFloorItemViewHolder.h0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (postData.i0() != null) {
                px7.a(2, postData.K(), px7.c, this.t, this.u);
            }
        }
    }

    public void r(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, ft7Var) == null) {
            this.l = ft7Var;
        }
    }

    public final void r0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048624, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            s0(textView, (PostData) tag);
        }
    }

    public final void s0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            ft7 ft7Var = this.l;
            if (ft7Var != null && ft7Var.i0()) {
                postData.V0(Boolean.FALSE);
                postData.J0(0);
                textView.setTag(null);
            } else if (postData.s() != null) {
                com.baidu.tbadk.core.data.MetaData s = postData.s();
                String str = this.k;
                if (str != null && !str.equals("0") && this.k.equals(s.getUserId())) {
                    postData.V0(Boolean.TRUE);
                    postData.J0(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0869);
                    textView.setBackgroundColor(0);
                    ms4 d2 = ms4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.o0()) {
                    ms4 d3 = ms4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f0341);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    ms4 d4 = ms4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds82));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fa);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    ms4 d5 = ms4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds108));
                    textView.setText(R.string.obfuscated_res_0x7f0f02fb);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    ms4 d6 = ms4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02f7);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    ms4 d7 = ms4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    postData.V0(Boolean.TRUE);
                    postData.J0(qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds134));
                    textView.setText(R.string.obfuscated_res_0x7f0f02f8);
                } else {
                    postData.V0(Boolean.FALSE);
                    postData.J0(0);
                }
            } else {
                postData.V0(Boolean.FALSE);
                postData.J0(0);
            }
        }
    }
}
