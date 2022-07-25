package com.repackage;

import android.graphics.drawable.Drawable;
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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
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
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.sub.SubPbLayout;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ls7;
import com.repackage.ux5;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class bu7 extends du7<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public int B;
    public boolean C;
    public boolean D;
    public int E;
    public String F;
    public eg<ConstrainImageLayout> G;
    public eg<TbImageView> H;
    public ls7 I;
    public int o;
    public TbRichTextView.s p;
    public boolean q;
    public float r;
    public String s;
    public jr7 t;
    public View.OnClickListener u;
    public View.OnClickListener v;
    public TbRichTextView.y w;
    public ls7 x;
    public View.OnLongClickListener y;
    public ox7 z;

    /* loaded from: classes5.dex */
    public class a implements fg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu7 a;

        public a(bu7 bu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.a) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements fg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu7 a;

        public b(bu7 bu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu7Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.fg
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
        @Override // com.repackage.fg
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.fg
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.a);
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

    /* loaded from: classes5.dex */
    public class c implements ls7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bu7 a;

        public c(bu7 bu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bu7Var;
        }

        @Override // com.repackage.ls7.a
        public boolean a(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean b(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, motionEvent)) == null) {
                if (this.a.x != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.v == null) {
                        this.a.x.a(view2);
                        this.a.x.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.v.onClick(view2);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.repackage.ls7.a
        public boolean c(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view2, motionEvent)) == null) {
                if (view2 == null || !((pbFragment = this.a.j) == null || pbFragment.O5() == null || this.a.j.O5().H1())) {
                    return true;
                }
                if (view2 instanceof RelativeLayout) {
                    this.a.p0(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.a.p0((RelativeLayout) parent);
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

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ bu7 c;

        public d(bu7 bu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bu7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.R.getVisibility() == 8;
                this.c.n0(this.a, !z, this.b.E());
                this.b.y0(!z);
                this.c.K0(this.a, this.b);
                PbFragment pbFragment = this.c.j;
                if (pbFragment == null || pbFragment.O5() == null || this.c.j.O5().l1() == null || this.c.j.O5().R0() == null || z || this.a.a().getTop() >= this.c.j.O5().l1().getMeasuredHeight()) {
                    return;
                }
                this.c.j.O5().R0().setSelectionFromTop(ListUtils.getPosition(this.c.j.O5().R0().getData(), this.b) + this.c.j.O5().R0().getHeaderViewsCount(), this.c.j.O5().l1().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ String b;

        public e(bu7 bu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var, pbCommenFloorItemViewHolder, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                String str = this.b;
                PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                lv7.a(measuredWidth, str, pbCommenFloorItemViewHolder.f, pbCommenFloorItemViewHolder.g, pbCommenFloorItemViewHolder.F, pbCommenFloorItemViewHolder.I, pbCommenFloorItemViewHolder.H);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public f(bu7 bu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.t.performClick();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tw7 b;
        public final /* synthetic */ bu7 c;

        /* loaded from: classes5.dex */
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
                    gVar.b.b.a(gVar.c.t, null, this.a, gVar.a.n.getLayoutStrategy());
                }
            }
        }

        public g(bu7 bu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, tw7 tw7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var, pbCommenFloorItemViewHolder, tw7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bu7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = tw7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f091f0d) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091f0d)) == null || this.a.b == null || this.b == null) {
                    return;
                }
                qg.a().postDelayed(new a(this, postData), 100L);
                String Q = this.c.t.Q();
                if ((StringUtils.isNull(Q) || "0".equals(this.c.t.Q())) && this.c.t.O() != null) {
                    Q = this.c.t.O().getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.t.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.J()).param("obj_source", this.c.G0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bu7 b;

        public h(bu7 bu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bu7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.t == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.l) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.l.getImgAgree() ? 1 : 2;
            String Q = this.b.t.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.t.Q())) && this.b.t.O() != null) {
                Q = this.b.t.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.t.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.l.getData().postId).param("obj_source", this.b.G0(this.a.l)).param("obj_type", i));
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ bu7 b;

        public i(bu7 bu7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bu7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = bu7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.t == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.b0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.b0.getImgAgree() ? 1 : 2;
            String Q = this.b.t.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.t.Q())) && this.b.t.O() != null) {
                Q = this.b.t.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.t.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.b0.getData().postId).param("obj_source", this.b.G0(this.a.b0)).param("obj_type", i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bu7(qy7 qy7Var, BdUniqueId bdUniqueId) {
        super(qy7Var, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qy7Var, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((qy7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = null;
        this.q = true;
        this.r = 1.0f;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = true;
        this.C = true;
        this.D = false;
        this.E = 0;
        this.F = null;
        this.G = new eg<>(new a(this), 6, 0);
        this.H = new eg<>(new b(this), 12, 0);
        this.I = new ls7(new c(this));
        if (qy7Var != null && qy7Var.F() != null) {
            this.B = qy7Var.F().Q1();
        }
        this.o = Z(R.dimen.tbds14);
    }

    public final void A0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.b == null) {
            return;
        }
        qy7 qy7Var = this.i;
        if (qy7Var != null && qy7Var.F() != null && StringHelper.equals(this.i.F().s1(), postData.J())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.V() != null) {
                TbRichText Q = postData.Q();
                sz7.c(postData.V(), pbCommenFloorItemViewHolder.L, false, false, Q != null && StringUtils.isNull(Q.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.L.setVisibility(8);
        }
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.F() != 2 && postData.F() != 4) {
                pbCommenFloorItemViewHolder.S.setVisibility(8);
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                o0(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.S.setOnClickListener(new d(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.S.setVisibility(0);
                n0(pbCommenFloorItemViewHolder, postData.i0(), postData.E());
                o0(true, pbCommenFloorItemViewHolder, postData);
            }
            K0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.g(postData.Q, postData.J(), this.D);
    }

    /* JADX WARN: Removed duplicated region for block: B:245:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06bf  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0702  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x07bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048580, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.s() != null) {
            postData.s().isBaijiahaoUser();
        }
        if (postData.P) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.d.setVisibility(8);
        }
        ThreadData threadData = null;
        pbCommenFloorItemViewHolder.m.setTag(null);
        pbCommenFloorItemViewHolder.m.setUserId(null);
        pbCommenFloorItemViewHolder.f.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.G.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.n.setIsHost(false);
        if (postData.s() != null) {
            String str = this.s;
            if (str != null && !str.equals("0") && this.s.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.n.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.s().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.s().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.I;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.obfuscated_res_0x7f091f41, postData.s().getUserId());
                qy7 qy7Var = this.i;
                if (qy7Var != null && qy7Var.N() != null) {
                    pbCommenFloorItemViewHolder.I.setOnClickListener(this.i.N().d.c);
                }
                int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10);
                UserIconBox userIconBox2 = pbCommenFloorItemViewHolder.I;
                i3 = R.id.obfuscated_res_0x7f091f41;
                userIconBox2.g(iconInfo, 2, f2, f2, f3);
            } else {
                i3 = R.id.obfuscated_res_0x7f091f41;
            }
            if (pbCommenFloorItemViewHolder.H != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.H.setTag(tShowInfoNew.get(0).getUrl());
                }
                qy7 qy7Var2 = this.i;
                if (qy7Var2 != null && qy7Var2.N() != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(this.i.N().d.e);
                }
                int f4 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.H.h(tShowInfoNew, 3, f4, f4, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lv7.l(pbCommenFloorItemViewHolder.f);
                    } else {
                        vr4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0301, 1);
            }
            String avater = postData.s().getAvater();
            int i4 = postData.a0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f.setTag(i3, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f49, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f4b, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f37, fy7.i(this.t, postData, postData.b0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f.setText(lq7.b(this.a, pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f091f18, lq7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.G.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.G.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setVisibility(8);
                pbCommenFloorItemViewHolder.G.setVisibility(0);
                pbCommenFloorItemViewHolder.G.getHeadView().J(avater, 28, false);
                pbCommenFloorItemViewHolder.G.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.G.getHeadView().setUserName(postData.s().getUserName());
                jr7 jr7Var = this.t;
                pbCommenFloorItemViewHolder.G.getHeadView().setFid(jr7Var != null ? jr7Var.m() : "");
                jr7 jr7Var2 = this.t;
                pbCommenFloorItemViewHolder.G.getHeadView().setFName(jr7Var2 != null ? jr7Var2.n() : "");
                pbCommenFloorItemViewHolder.G.getHeadView().setFloor(postData.B());
                pbCommenFloorItemViewHolder.G.getHeadView().setTid(postData.J());
                pbCommenFloorItemViewHolder.G.getHeadView().setTag(R.id.obfuscated_res_0x7f091f37, fy7.i(this.t, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.G.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.m.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.m, postData.s(), 4);
                pbCommenFloorItemViewHolder.m.setUserId(postData.s().getUserId());
                jr7 jr7Var3 = this.t;
                pbCommenFloorItemViewHolder.m.setFid(jr7Var3 != null ? jr7Var3.m() : "");
                jr7 jr7Var4 = this.t;
                pbCommenFloorItemViewHolder.m.setFName(jr7Var4 != null ? jr7Var4.n() : "");
                pbCommenFloorItemViewHolder.m.setFloor(postData.B());
                pbCommenFloorItemViewHolder.m.setTid(postData.J());
                pbCommenFloorItemViewHolder.m.setUserName(postData.s().getUserName(), postData.a0());
                pbCommenFloorItemViewHolder.m.setTag(R.id.obfuscated_res_0x7f091f4b, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.m.setTag(R.id.obfuscated_res_0x7f091f37, fy7.i(this.t, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.m.setImageDrawable(null);
                pbCommenFloorItemViewHolder.m.J(avater, 28, false);
                pbCommenFloorItemViewHolder.m.setVisibility(0);
                pbCommenFloorItemViewHolder.G.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.e(true);
                pbCommenFloorItemViewHolder.m.setLiveStatus(1);
                pbCommenFloorItemViewHolder.m.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.G.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.G.getHeadView().setAlaInfo(postData.s().getAlaInfo());
                threadData = null;
            } else {
                pbCommenFloorItemViewHolder.e(false);
                pbCommenFloorItemViewHolder.m.setLiveStatus(0);
                threadData = null;
                pbCommenFloorItemViewHolder.m.setAlaInfo(null);
                pbCommenFloorItemViewHolder.G.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.G.getHeadView().setAlaInfo(null);
            }
            U0(pbCommenFloorItemViewHolder.g, postData);
        }
        qy7 qy7Var3 = this.i;
        int level_id = (qy7Var3 == null || qy7Var3.N() == null || !this.i.N().v0() || postData.s() == null) ? 0 : postData.s().getLevel_id();
        jr7 jr7Var5 = this.t;
        if (jr7Var5 != null && jr7Var5.g0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.F.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.F, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.F.setVisibility(8);
        }
        int i5 = 15;
        if (pbCommenFloorItemViewHolder.I.getChildCount() == 1) {
            i5 = 13;
        } else if (pbCommenFloorItemViewHolder.I.getChildCount() > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.g.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.H.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.x() > 1000) {
            i5 -= 2;
        }
        if (postData.x() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            pbCommenFloorItemViewHolder.I.setVisibility(8);
            if (pbCommenFloorItemViewHolder.I.getChildCount() == 1) {
                i5 += 2;
            } else if (pbCommenFloorItemViewHolder.I.getChildCount() > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.g.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.g.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.F.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
        }
        int e2 = lv7.e();
        String name_show2 = postData.s() != null ? postData.s().getName_show() : "";
        int d2 = je5.d(name_show2);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                name_show2 = je5.n(name_show2, i6) + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            name_show2 = je5.n(name_show2, e2) + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f.setText(F0(postData.s().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f.setText(name_show2);
            pbCommenFloorItemViewHolder.e.post(new e(this, pbCommenFloorItemViewHolder, name_show2));
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0d, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0f, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f091f1b, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f091f1a, Integer.valueOf(postData.B()));
        sparseArray.put(R.id.obfuscated_res_0x7f091f01, postData.J());
        sparseArray.put(R.id.obfuscated_res_0x7f0916ed, pbCommenFloorItemViewHolder.l);
        sparseArray.put(R.id.obfuscated_res_0x7f0916ee, pbCommenFloorItemViewHolder.b0);
        sparseArray.put(R.id.obfuscated_res_0x7f0916eb, pbCommenFloorItemViewHolder.t);
        sparseArray.put(R.id.obfuscated_res_0x7f0916ec, pbCommenFloorItemViewHolder.u);
        jr7 jr7Var6 = this.t;
        if (jr7Var6 != null && jr7Var6.O() != null) {
            threadData = this.t.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0916ea, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0916ea, Boolean.FALSE);
        }
        boolean z7 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        jr7 jr7Var7 = this.t;
        if (jr7Var7 == null || jr7Var7.V() == 0 || H0()) {
            z = false;
            z2 = false;
        } else {
            z = (this.t.V() == 1002 || this.t.V() == 3) ? false : true;
            z2 = (this.t.V() == 3 || this.t.g0()) ? false : true;
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
        jr7 jr7Var8 = this.t;
        if (jr7Var8 != null && jr7Var8.O() != null && this.t.O().getAuthor() != null && postData.s() != null) {
            String userId2 = this.t.O().getAuthor().getUserId();
            String userId3 = postData.s().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = false;
                    z5 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                z3 = true;
                z6 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z5 = true;
                    z3 = true;
                }
                if (z7) {
                    z = false;
                    z4 = false;
                    z3 = false;
                }
                int i7 = postData.B() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f34, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(this.t.V()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091efe, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091eff, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f00, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f34, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f08, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f44, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f45, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091f43, postData.s().getName_show());
                    }
                    if (this.t.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091f47, this.t.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f46, postData.J());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f48, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f32, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091f05, Boolean.valueOf(postData.g0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091f10, Integer.valueOf(this.t.V()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef4, Boolean.valueOf(z5));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef5, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f091ef3, postData.J());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f091f32, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f091f09, Boolean.valueOf(z6));
                pbCommenFloorItemViewHolder.n.setTag(sparseArray);
            }
        }
        z3 = z2;
        z4 = false;
        z5 = false;
        z6 = false;
        if (postData != null) {
            z5 = true;
            z3 = true;
        }
        if (z7) {
        }
        if (postData.B() != 1) {
        }
        if (!z) {
        }
        if (!z4) {
        }
        if (!z3) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091f09, Boolean.valueOf(z6));
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
    }

    public final SpannableStringBuilder F0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new ux5.a(str, R.drawable.pic_smalldot_title));
            return ux5.h(this.i.N(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String G0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            SparseArray sparseArray = (SparseArray) view2.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.obfuscated_res_0x7f091784);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.obfuscated_res_0x7f091784);
            view2.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    public final boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            jr7 jr7Var = this.t;
            if (jr7Var == null || jr7Var.O() == null) {
                return false;
            }
            return this.t.O().isBlocked();
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: I0 */
    public PbCommenFloorItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d06a6, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091767)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d069e, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.i.N().getPageContext(), inflate, this.B);
            pbCommenFloorItemViewHolder.o.setConstrainLayoutPool(this.G);
            pbCommenFloorItemViewHolder.o.setImageViewPool(this.H);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.q;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.C);
                pbCommenFloorItemViewHolder.q.setIsVideoThread(false);
            }
            R0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.n;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.A);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View J0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.S(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            R0(pbCommenFloorItemViewHolder);
            N0(pbCommenFloorItemViewHolder);
            j0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) y(i2);
            if (postData2 != null) {
                postData2.b0 = i2 + 1;
                l0(postData2);
                k0(postData2);
                postData2.P0();
                q0(postData2);
                v0(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText Q = postData.Q();
            Q.isChanged = true;
            pbCommenFloorItemViewHolder.n.setText(Q, true, this.p);
        }
    }

    public final void L0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, postData) == null) {
            String userId = postData.s().getUserId();
            jr7 jr7Var = this.t;
            String m = jr7Var != null ? jr7Var.m() : "";
            jr7 jr7Var2 = this.t;
            String n = jr7Var2 != null ? jr7Var2.n() : "";
            int B = postData.B();
            String J = postData.J();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", m);
            statisticItem.param("fname", n);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", J);
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

    public void M0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.A = z;
        }
    }

    public final void N0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.b.setOnTouchListener(this.I);
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.y);
            if (this.i.N() == null || this.i.N().getPageContext() == null || this.i.N().getPageContext().getOrignalPage() == null) {
                return;
            }
            rw7 rw7Var = this.i.N().d;
            pbCommenFloorItemViewHolder.f.setOnClickListener(rw7Var.b);
            pbCommenFloorItemViewHolder.m.setOnClickListener(rw7Var.b);
            pbCommenFloorItemViewHolder.m0.setOnClickListener(rw7Var.d);
            pbCommenFloorItemViewHolder.l0.setOnClickListener(rw7Var.d);
            pbCommenFloorItemViewHolder.G.setOnClickListener(rw7Var.b);
            pbCommenFloorItemViewHolder.G.getHeadView().setOnClickListener(rw7Var.b);
            pbCommenFloorItemViewHolder.n.setOnLongClickListener(this.y);
            pbCommenFloorItemViewHolder.n.setOnTouchListener(this.I);
            pbCommenFloorItemViewHolder.n.setCommonTextViewOnClickListener(this.v);
            pbCommenFloorItemViewHolder.n.setOnImageClickListener(this.w);
            pbCommenFloorItemViewHolder.n.setOnImageTouchListener(this.I);
            pbCommenFloorItemViewHolder.n.setOnEmotionClickListener(rw7Var.f);
            pbCommenFloorItemViewHolder.n.setOnVoiceAfterClickListener(this.v);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.M.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.r.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.s.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.c0.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.g0.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.d0.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            tw7 tw7Var = this.i.N().e;
            pbCommenFloorItemViewHolder.t.setOnClickListener(this.v);
            pbCommenFloorItemViewHolder.u.setOnClickListener(new g(this, pbCommenFloorItemViewHolder, tw7Var));
            pbCommenFloorItemViewHolder.l.x = new h(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.b0.x = new i(this, pbCommenFloorItemViewHolder);
        }
    }

    public void O0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.D = z;
        }
    }

    public void P0(ls7 ls7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ls7Var) == null) {
            this.x = ls7Var;
        }
    }

    public void Q0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, sVar) == null) {
            this.p = sVar;
        }
    }

    public final void R0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            T0(pbCommenFloorItemViewHolder.g);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lv7.l(pbCommenFloorItemViewHolder.f);
                } else {
                    vr4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.i, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.E, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.s, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.e0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.q, pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.r.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.obfuscated_res_0x7f08096a, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.u, R.drawable.obfuscated_res_0x7f08096b, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.q.d();
            pbCommenFloorItemViewHolder.o.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.N, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.M, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.Q, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.T, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.R.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f03eb);
            } else {
                jr7 jr7Var = this.t;
                if (jr7Var != null && StringUtils.isNull(jr7Var.k())) {
                    pbCommenFloorItemViewHolder.T.setText(this.t.k());
                } else {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f05ca);
                }
            }
            pbCommenFloorItemViewHolder.l.K(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.K, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.c0, R.drawable.obfuscated_res_0x7f080945, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.g0, R.drawable.obfuscated_res_0x7f080945, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    @Override // com.repackage.du7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        J0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public void S0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.c0() != null) {
                VirtualImageCustomFigure c0 = postData.c0();
                pbCommenFloorItemViewHolder.m0.setHeadImageViewResource(c0.getFigureUrl());
                pbCommenFloorItemViewHolder.m0.setTid(postData.J());
                pbCommenFloorItemViewHolder.m0.setLocate(pv7.c);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(c0.getBackGroundType())) {
                    str = c0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.m0.setHeadImageBackgroundColorResource(c0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(c0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.m0.setHeadImageBackgroundResource(c0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.m0.d(postData.s());
                pbCommenFloorItemViewHolder.k0.setVisibility(8);
                pbCommenFloorItemViewHolder.n0.setVisibility(0);
                pbCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f091f41, postData.s().getUserId());
                pbCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f091f49, postData.s().getUserName());
            } else {
                pbCommenFloorItemViewHolder.n0.setVisibility(8);
                pbCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f091f41, null);
                pbCommenFloorItemViewHolder.m0.setTag(R.id.obfuscated_res_0x7f091f49, null);
                pbCommenFloorItemViewHolder.k0.setVisibility(0);
            }
            if (postData.d0() != null && !TextUtils.isEmpty(postData.d0().b())) {
                pbCommenFloorItemViewHolder.l0.setData(postData.d0().b(), null, str);
                pbCommenFloorItemViewHolder.l0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.o0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.o0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f091f41, postData.s().getUserId());
                pbCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f091f49, postData.s().getUserName());
                this.E = pv7.d;
                this.F = pbCommenFloorItemViewHolder.l0.getData();
                pbCommenFloorItemViewHolder.m0.setWithBubble(this.E);
                pbCommenFloorItemViewHolder.m0.setBubbleName(this.F);
            } else {
                if (pbCommenFloorItemViewHolder.o0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.o0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.o0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.l0.setVisibility(8);
                pbCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f091f49, null);
                pbCommenFloorItemViewHolder.l0.setTag(R.id.obfuscated_res_0x7f091f41, null);
                int i2 = pv7.e;
                this.E = i2;
                pbCommenFloorItemViewHolder.m0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.m0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.m0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (postData.c0() != null) {
                pv7.a(2, postData.J(), pv7.c, this.E, this.F);
            }
        }
    }

    public final void T0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            U0(textView, (PostData) tag);
        }
    }

    public final void U0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            jr7 jr7Var = this.t;
            if (jr7Var != null && jr7Var.g0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.s() != null) {
                MetaData s = postData.s();
                String str = this.s;
                if (str != null && !str.equals("0") && this.s.equals(s.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.obfuscated_res_0x7f0f0857);
                    textView.setBackgroundColor(0);
                    vr4 d2 = vr4.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.v(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && postData.h0()) {
                    vr4 d3 = vr4.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f033b);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    vr4 d4 = vr4.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f6);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    vr4 d5 = vr4.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f7);
                } else if (s.getIs_bawu() == 1 && "pri_content_assist".equals(s.getBawu_type())) {
                    vr4 d6 = vr4.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f3);
                } else if (s.getIs_bawu() == 1 && "pri_manage_assist".equals(s.getBawu_type())) {
                    vr4 d7 = vr4.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.obfuscated_res_0x7f0f02f4);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.q = z;
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.y = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, onClickListener) == null) {
            this.v = onClickListener;
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.n.setTextViewOnTouchListener(this.x);
            pbCommenFloorItemViewHolder.n.setTextViewCheckSelection(false);
        }
    }

    public final void k0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, postData) == null) {
            if (postData != null) {
                StatisticItem statisticItem = new StatisticItem("c14623");
                statisticItem.param("post_id", postData.J());
                statisticItem.param("pid", postData.J());
                statisticItem.param("tid", postData.X());
                statisticItem.param("fid", postData.G());
                statisticItem.param("fname", postData.H());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                TiebaStatic.log(statisticItem);
            }
            jr7 jr7Var = this.t;
            if (jr7Var != null) {
                if (jr7Var.r0()) {
                    AbsVideoPbFragment absVideoPbFragment = this.k;
                    if (absVideoPbFragment != null) {
                        fy7.e(absVideoPbFragment.getUniqueId(), this.t, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                        return;
                    }
                    return;
                }
                PbFragment pbFragment = this.j;
                if (pbFragment != null) {
                    fy7.e(pbFragment.getUniqueId(), this.t, postData, postData.b0, postData.a0 ? 2 : 8, "common_exp_source_pb_comment");
                }
            }
        }
    }

    public void l(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, onClickListener) == null) {
            this.u = onClickListener;
        }
    }

    public final void l0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, postData) == null) && postData.C == 0 && postData.K) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.J());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            qy7 qy7Var = this.i;
            if (qy7Var != null) {
                int Q1 = qy7Var.F().Q1();
                if (1 == Q1 || 2 == Q1) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == Q1) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.s() == null || postData.s().getAlaInfo() == null || postData.s().getAlaInfo().live_status != 1) {
                return;
            }
            L0(postData);
        }
    }

    public final void m0(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048606, this, tbRichTextView, view2, z) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k = (((pi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int Z = z ? Z(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k - Z) * this.r));
        tbRichTextView.getLayoutStrategy().H = (k - Z) - Z(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f * this.r));
    }

    public final void n0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f05ca);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.T.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.R.setVisibility(0);
            pbCommenFloorItemViewHolder.T.setText(R.string.obfuscated_res_0x7f0f03eb);
        }
    }

    public void o(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, yVar) == null) {
            this.w = yVar;
        }
    }

    public final void o0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048609, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.K) == null || pbCommenFloorItemViewHolder.S == null || !(view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.S.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.S());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.K.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.S.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.n.getLayoutStrategy().l(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.n.getLayoutStrategy().l(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.S.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = pi.f(this.a, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.K.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().l(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().m(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = pi.f(this.a, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.K.setLayoutParams(layoutParams);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, view2) == null) {
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.s = str;
        }
    }

    public final void p0(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).b0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.b0.setAgreeSource(2);
        pbCommenFloorItemViewHolder.b0.I();
    }

    public final void q0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = fy7.i(this.t, postData, postData.b0, postData.a0 ? 2 : 8, 6);
        postData.c0 = i2;
        if (ListUtils.isEmpty(postData.S())) {
            return;
        }
        Iterator<PostData> it = postData.S().iterator();
        while (it.hasNext()) {
            it.next().c0 = i2;
        }
    }

    public final void r0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.q) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams.topMargin = Z(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = Z(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.n.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.n.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.n.k0(null);
            }
            pbCommenFloorItemViewHolder.n.setTextViewOnTouchListener(this.I);
            pbCommenFloorItemViewHolder.n.setTextViewCheckSelection(false);
        }
    }

    public void s(jr7 jr7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, jr7Var) == null) {
            this.t = jr7Var;
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.J) == null || this.t == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        jr7 jr7Var;
        jr7 jr7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z3 = true;
        if (postData.B() > 0 && (jr7Var2 = this.t) != null && !jr7Var2.g0()) {
            String format = String.format(this.a.getString(R.string.obfuscated_res_0x7f0f0966), Integer.valueOf(postData.B()));
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            pbCommenFloorItemViewHolder.E.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
            z = false;
        }
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z2 = true;
                o05 N = postData.N();
                z3 = (N != null || StringUtils.isNull(N.b()) || (jr7Var = this.t) == null || jr7Var.g0()) ? false : false;
                if (!z) {
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                    i2 = this.o;
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
                    i2 = 0;
                }
                if (z3 && !z2) {
                    pbCommenFloorItemViewHolder.j.setVisibility(8);
                    i3 = 0;
                } else {
                    pbCommenFloorItemViewHolder.j.setVisibility(0);
                    i3 = this.o;
                }
                pbCommenFloorItemViewHolder.h.setPadding(i2, 0, i3, 0);
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Y()), "yyyy"))) {
                    pbCommenFloorItemViewHolder.h.setText(StringHelper.getFormatTimeShort(postData.Y()));
                } else {
                    pbCommenFloorItemViewHolder.h.setText(StringHelper.getFormatTime(postData.Y()));
                }
                if (!z2) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                    pbCommenFloorItemViewHolder.k.setPadding(this.o, 0, 0, 0);
                    TextView textView = pbCommenFloorItemViewHolder.k;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f149d) + str);
                } else if (z3) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                    pbCommenFloorItemViewHolder.k.setPadding(this.o, 0, 0, 0);
                    if (postData.Z) {
                        pbCommenFloorItemViewHolder.k.setText(StringHelper.cutStringWithSuffix(N.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbCommenFloorItemViewHolder.k.setText(N.b());
                    }
                } else {
                    pbCommenFloorItemViewHolder.k.setVisibility(8);
                }
                TextView textView2 = pbCommenFloorItemViewHolder.e0;
                textView2.setText(((Object) pbCommenFloorItemViewHolder.h.getText()) + "  • ");
            }
        }
        z2 = false;
        o05 N2 = postData.N();
        if (N2 != null) {
        }
        if (!z) {
        }
        if (z3) {
        }
        pbCommenFloorItemViewHolder.j.setVisibility(0);
        i3 = this.o;
        pbCommenFloorItemViewHolder.h.setPadding(i2, 0, i3, 0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.Y()), "yyyy"))) {
        }
        if (!z2) {
        }
        TextView textView22 = pbCommenFloorItemViewHolder.e0;
        textView22.setText(((Object) pbCommenFloorItemViewHolder.h.getText()) + "  • ");
    }

    public final void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048618, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.W.setVisibility(postData.Z ? 0 : 8);
    }

    public final void v0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048619, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        pbCommenFloorItemViewHolder.a0.setVisibility(0);
        pbCommenFloorItemViewHolder.p.setVisibility(0);
        pbCommenFloorItemViewHolder.d0.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(8);
        pbCommenFloorItemViewHolder.u.setVisibility(8);
        pbCommenFloorItemViewHolder.l.setVisibility(8);
        pbCommenFloorItemViewHolder.g0.setVisibility(8);
        E0(pbCommenFloorItemViewHolder, postData, view2, i2);
        s0(pbCommenFloorItemViewHolder, postData);
        w0(pbCommenFloorItemViewHolder, postData);
        z0(pbCommenFloorItemViewHolder, postData, view2);
        y0(pbCommenFloorItemViewHolder, postData, view2, i2);
        t0(pbCommenFloorItemViewHolder, postData);
        B0(pbCommenFloorItemViewHolder, postData);
        x0(pbCommenFloorItemViewHolder, postData);
        C0(pbCommenFloorItemViewHolder, postData);
        r0(pbCommenFloorItemViewHolder, postData);
        u0(pbCommenFloorItemViewHolder, postData);
        A0(pbCommenFloorItemViewHolder, postData);
        D0(pbCommenFloorItemViewHolder, postData);
        S0(pbCommenFloorItemViewHolder, postData);
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.p() == null) {
            return;
        }
        postData.p().threadId = this.i.F().j2();
        postData.p().objType = 1;
        postData.p().isInPost = true;
        ThreadData threadData = null;
        jr7 jr7Var = this.t;
        if (jr7Var != null && jr7Var.O() != null) {
            threadData = this.t.O();
        }
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.l.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.l.setThreadData(threadData);
        pbCommenFloorItemViewHolder.l.setData(postData.p());
        pbCommenFloorItemViewHolder.b0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.b0.setData(postData.p());
    }

    public final void x0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048621, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.P == null || pbCommenFloorItemViewHolder.M == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.R) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.P.setText(postData.R.liveTitle);
            pbCommenFloorItemViewHolder.M.setTag(postData.R);
            pbCommenFloorItemViewHolder.M.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.M.setVisibility(8);
    }

    public final void y0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048622, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.U() > 0) {
            pbCommenFloorItemViewHolder.s.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.s.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.s.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f091f0d, postData);
            if (postData.F() == 2) {
                pbCommenFloorItemViewHolder.s.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.s.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.r.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.t;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.t.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f091f0d, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.u;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.u.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f091f0d, postData);
        }
        pbCommenFloorItemViewHolder.r.setVisibility(8);
        if (!postData.g0() && !postData.f0(false)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.q.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.q.getLayoutParams();
            layoutParams2.topMargin = pi.f(this.a, R.dimen.tbds10);
            layoutParams2.leftMargin = pi.f(this.a, R.dimen.tbds148);
            layoutParams2.rightMargin = pi.f(this.a, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = pi.f(this.a, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.q.setLayoutParams(layoutParams2);
            if (this.z == null) {
                ox7 ox7Var = new ox7(this.a);
                this.z = ox7Var;
                ox7Var.f(this.m);
                this.z.h(this.u);
                this.z.e(this.v);
                String str = null;
                jr7 jr7Var = this.t;
                if (jr7Var != null && jr7Var.O() != null && this.t.O().getAuthor() != null) {
                    str = this.t.O().getAuthor().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                jr7 jr7Var2 = this.t;
                if (jr7Var2 != null) {
                    this.z.j(jr7Var2.V(), z);
                    this.z.i(this.t.O());
                }
            }
            this.z.g(postData.J());
            pbCommenFloorItemViewHolder.q.setSubPbAdapter(this.z);
            pbCommenFloorItemViewHolder.q.setVisibility(0);
            pbCommenFloorItemViewHolder.q.setData(postData, view2);
            pbCommenFloorItemViewHolder.q.setChildOnClickListener(this.v);
            pbCommenFloorItemViewHolder.q.setChildOnLongClickListener(this.y);
            pbCommenFloorItemViewHolder.q.setChildOnTouchListener(this.I);
        }
        if (postData.N) {
            pbCommenFloorItemViewHolder.K.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.K.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.s.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
        layoutParams3.topMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.r.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.p.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.p.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.f0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fa6));
    }

    public final void z0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048623, this, pbCommenFloorItemViewHolder, postData, view2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = pi.f(this.a, R.dimen.M_W_X007);
        layoutParams.leftMargin = pi.f(this.a, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.n.setPadding(0, 0, 0, 0);
        if (!this.q) {
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.n.k0(null);
            pbCommenFloorItemViewHolder.n.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.n.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f0811a8);
        }
        pbCommenFloorItemViewHolder.n.getLayoutStrategy().x(R.drawable.pic_video);
        m0(pbCommenFloorItemViewHolder.n, view2, !StringUtils.isNull(postData.t()));
        pbCommenFloorItemViewHolder.n.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.n.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.n.setIsFromCDN(this.m);
        pbCommenFloorItemViewHolder.n.setText(postData.Q(), true, this.p);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.n.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091ef1, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f091f0a, Boolean.FALSE);
        pbCommenFloorItemViewHolder.n.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091f04, sparseArray);
        pbCommenFloorItemViewHolder.g0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.c0.setTag(sparseArray);
    }
}
