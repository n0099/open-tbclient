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
import android.widget.FrameLayout;
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
import com.repackage.hu7;
import com.repackage.mz5;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class zv7 extends bw7<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fg<TbImageView> A;
    public hu7 B;
    public int g;
    public TbRichTextView.s h;
    public boolean i;
    public float j;
    public String k;
    public ft7 l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public TbRichTextView.y o;
    public hu7 p;
    public View.OnLongClickListener q;
    public rz7 r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public boolean w;
    public int x;
    public String y;
    public fg<ConstrainImageLayout> z;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ zv7 b;

        public a(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.l == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.d0) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.d0.getImgAgree() ? 1 : 2;
            String Q = this.b.l.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                Q = this.b.l.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.d0.getData().postId).param("obj_source", this.b.g0(this.a.d0)).param("obj_type", i));
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbCommenFloorItemViewHolder b;
        public final /* synthetic */ zv7 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: com.repackage.zv7$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class View$OnClickListenerC0638a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0638a(a aVar) {
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
                        b bVar = this.a.a;
                        zv7 zv7Var = bVar.c;
                        zv7Var.i0(((PostData) zv7Var.getItem(bVar.a)).s());
                    }
                }
            }

            /* renamed from: com.repackage.zv7$b$a$b  reason: collision with other inner class name */
            /* loaded from: classes7.dex */
            public class RunnableC0639b implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public RunnableC0639b(a aVar) {
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
                        b bVar = this.a.a;
                        ((PostData) bVar.c.getItem(bVar.a)).x0();
                        b bVar2 = this.a.a;
                        if (((PostData) bVar2.c.getItem(bVar2.a)).U() <= 0) {
                            b bVar3 = this.a.a;
                            ((PostData) bVar3.c.getItem(bVar3.a)).N0(Boolean.FALSE);
                            this.a.a.b.y0.setVisibility(8);
                            this.a.a.b.d0.setVisibility(0);
                        }
                    }
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.d0.getAgreeFlag()) {
                    b bVar = this.a;
                    ((PostData) bVar.c.getItem(bVar.a)).w0();
                    b bVar2 = this.a;
                    ((PostData) bVar2.c.getItem(bVar2.a)).N0(Boolean.TRUE);
                    this.a.b.d0.setVisibility(8);
                    this.a.b.y0.setVisibility(0);
                    this.a.b.y0.setOnClickListener(new View$OnClickListenerC0638a(this));
                    this.a.b.y0.postDelayed(new RunnableC0639b(this), 5000L);
                }
            }
        }

        public b(zv7 zv7Var, int i, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, Integer.valueOf(i), pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zv7Var;
            this.a = i;
            this.b = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && UtilHelper.isCurrentAccount(this.c.l.O().getAuthor().getUserId()) && this.c.l.O().isQuestionThread() && !UtilHelper.isCurrentAccount(((PostData) this.c.getItem(this.a)).s().getUserId())) {
                if (this.b.d0.getAgreeFlag()) {
                    ((PostData) this.c.getItem(this.a)).O0(1);
                    this.b.x0.setVisibility(0);
                    ((PostData) this.c.getItem(this.a)).H0(true);
                    this.b.h.setVisibility(8);
                    this.b.d0.postDelayed(new a(this), 900L);
                    return;
                }
                ((PostData) this.c.getItem(this.a)).O0(0);
                this.b.y0.setVisibility(8);
                this.b.x0.setVisibility(8);
                this.b.d0.setVisibility(0);
                ((PostData) this.c.getItem(this.a)).H0(false);
                if (((PostData) this.c.getItem(this.a)).W().booleanValue()) {
                    this.b.h.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements gg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public c(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
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

    /* loaded from: classes7.dex */
    public class d implements gg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public d(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
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

    /* loaded from: classes7.dex */
    public class e implements hu7.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zv7 a;

        public e(zv7 zv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zv7Var;
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
                if (this.a.p != null) {
                    if (!(view2 instanceof TbListTextView) || this.a.n == null) {
                        this.a.p.a(view2);
                        this.a.p.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.a.n.onClick(view2);
                    PbFragment pbFragment = this.a.b;
                    if (pbFragment != null) {
                        pbFragment.d7(false);
                        return true;
                    }
                    return true;
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
                if (view2 == null || (!((pbFragment = this.a.b) == null || pbFragment.S5() == null || this.a.b.S5().H1()) || view2.getId() == R.id.obfuscated_res_0x7f0909f1)) {
                    return true;
                }
                if (view2 instanceof FrameLayout) {
                    this.a.O(view2);
                } else {
                    ViewParent parent = view2.getParent();
                    int i = 0;
                    while (true) {
                        if (parent == null || i >= 10) {
                            break;
                        } else if (parent instanceof FrameLayout) {
                            this.a.O((FrameLayout) parent);
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

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ zv7 c;

        public f(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zv7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean z = this.a.T.getVisibility() == 8;
                this.c.L(this.a, !z, this.b.E());
                this.b.K0(!z);
                this.c.l0(this.a, this.b);
                PbFragment pbFragment = this.c.b;
                if (pbFragment == null || pbFragment.S5() == null || this.c.b.S5().l1() == null || this.c.b.S5().R0() == null || z || this.a.getView().getTop() >= this.c.b.S5().l1().getMeasuredHeight()) {
                    return;
                }
                this.c.b.S5().R0().setSelectionFromTop(ListUtils.getPosition(this.c.b.S5().R0().getData(), this.b) + this.c.b.S5().R0().getHeaderViewsCount(), this.c.b.S5().l1().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public g(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder};
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

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y0.setVisibility(8);
                this.a.d0.setVisibility(0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ String[] c;
        public final /* synthetic */ int d;
        public final /* synthetic */ zv7 e;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ h f;

            public a(h hVar, int i, int i2, int i3, int i4, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i5 = newInitContext.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f = hVar;
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
                    int h = lx7.h(this.a, this.b, this.f.a.g.getWidth(), this.c, this.d, this.e);
                    h hVar = this.f;
                    hVar.e.J(hVar.b, hVar.a, h, hVar.d);
                }
            }
        }

        public h(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, String[] strArr, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder, postData, strArr, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = zv7Var;
            this.a = pbCommenFloorItemViewHolder;
            this.b = postData;
            this.c = strArr;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.a.e.getMeasuredWidth();
                this.e.e0();
                boolean z = true;
                boolean z2 = !this.e.N(this.b);
                int width = !StringUtils.isNull(this.c[0]) ? this.a.g.getWidth() : 0;
                int width2 = this.a.J.getVisibility() == 8 ? 0 : this.a.J.getWidth() + lx7.c + lx7.b;
                int width3 = this.a.i.getVisibility() == 8 ? 0 : this.a.i.getWidth() + lx7.b;
                int width4 = this.a.H.getVisibility() == 8 ? 0 : this.a.H.getWidth() + lx7.b;
                int h = lx7.h(measuredWidth, width2, width, width3, width4, z2);
                if (h > 0 || StringUtils.isNull(this.c[0]) || if5.d(this.c[0]) <= lx7.g()) {
                    z = false;
                } else {
                    String[] strArr = this.c;
                    strArr[0] = if5.n(strArr[0], lx7.g());
                    this.a.g.setText(this.c[0] + StringHelper.STRING_MORE);
                }
                if (this.a.g.getText() != null) {
                    PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = this.a;
                    pbCommenFloorItemViewHolder.f.setText(pbCommenFloorItemViewHolder.g.getText());
                }
                if (!z) {
                    this.e.J(this.b, this.a, h, this.d);
                } else {
                    this.a.g.post(new a(this, measuredWidth, width2, width3, width4, z2));
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;

        public i(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder};
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
                this.a.v.performClick();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ ty7 b;
        public final /* synthetic */ zv7 c;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ j b;

            public a(j jVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {jVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = jVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    j jVar = this.b;
                    jVar.b.b.a(jVar.c.l, null, this.a, jVar.a.p.getLayoutStrategy());
                }
            }
        }

        public j(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, ty7 ty7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder, ty7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zv7Var;
            this.a = pbCommenFloorItemViewHolder;
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
                TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.c.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.K()).param("obj_source", this.c.g0(view2)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class k implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ zv7 b;

        public k(zv7 zv7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zv7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zv7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.l == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.n) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.n.getImgAgree() ? 1 : 2;
            String Q = this.b.l.Q();
            if ((StringUtils.isNull(Q) || "0".equals(this.b.l.Q())) && this.b.l.O() != null) {
                Q = this.b.l.O().getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", Q).param("fid", this.b.l.m()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.n.getData().postId).param("obj_source", this.b.g0(this.a.n)).param("obj_type", i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zv7(t08 t08Var, BdUniqueId bdUniqueId) {
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
        this.q = null;
        this.r = null;
        this.t = true;
        this.v = true;
        this.w = false;
        this.x = 0;
        this.y = null;
        this.z = new fg<>(new c(this), 6, 0);
        this.A = new fg<>(new d(this), 12, 0);
        this.B = new hu7(new e(this));
        if (t08Var != null && t08Var.K() != null) {
            this.u = t08Var.K().P1();
        }
        this.g = s(R.dimen.tbds14);
    }

    public final void F(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.p);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public final void G(PostData postData) {
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

    public final void H(PostData postData) {
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
            m0(postData);
        }
    }

    public final void J(PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048579, this, postData, pbCommenFloorItemViewHolder, i2, i3) == null) {
            if (i2 > postData.l0() + postData.L()) {
                if (pbCommenFloorItemViewHolder.K != null && postData.s() != null) {
                    pbCommenFloorItemViewHolder.K.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
                    t08 t08Var = this.a;
                    if (t08Var != null && t08Var.P() != null) {
                        pbCommenFloorItemViewHolder.K.setOnClickListener(this.a.P().d.c);
                    }
                    ArrayList<IconData> iconInfo = postData.s().getIconInfo();
                    int f2 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    pbCommenFloorItemViewHolder.K.g(iconInfo, i3, f2, f2, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                }
                if (postData.W().booleanValue() && !postData.J()) {
                    pbCommenFloorItemViewHolder.h.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.h.setVisibility(8);
                }
            } else if (i2 > postData.L()) {
                if (postData.W().booleanValue() && !postData.J()) {
                    pbCommenFloorItemViewHolder.h.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.h.setVisibility(8);
                }
            } else {
                pbCommenFloorItemViewHolder.K.setVisibility(8);
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
        }
    }

    public final void K(TbRichTextView tbRichTextView, View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048580, this, tbRichTextView, view2, z) == null) || tbRichTextView == null || view2 == null) {
            return;
        }
        int k2 = (((qi.k(TbadkCoreApplication.getInst()) - view2.getPaddingLeft()) - view2.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k2 = (k2 - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int s = z ? s(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k2 - s) * this.j));
        tbRichTextView.getLayoutStrategy().H = (k2 - s) - s(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k2 * 1.618f * this.j));
    }

    public final void L(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.T.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f05d8);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.V.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.T.setVisibility(0);
            pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f03f6);
        }
    }

    public final void M(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view2 = pbCommenFloorItemViewHolder.M) == null || pbCommenFloorItemViewHolder.U == null || !(view2.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.U.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.Y());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.M.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.U.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.U.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = qi.f(this.mContext, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.M.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().l(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().m(qi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = qi.f(this.mContext, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.M.setLayoutParams(layoutParams);
        }
    }

    public final boolean N(PostData postData) {
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

    public final void O(View view2) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || view2 == null || !(view2.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view2.getTag()).d0) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.d0.setAgreeSource(2);
        pbCommenFloorItemViewHolder.d0.I();
    }

    public final void P(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = i08.i(this.l, postData, postData.b0, postData.a0 ? 2 : 8, 6);
        postData.c0 = i2;
        if (ListUtils.isEmpty(postData.Y())) {
            return;
        }
        Iterator<PostData> it = postData.Y().iterator();
        while (it.hasNext()) {
            it.next().c0 = i2;
        }
    }

    public final void Q(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.i) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams.topMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                layoutParams.bottomMargin = s(R.dimen.obfuscated_res_0x7f0701d5);
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.p.k0(postData.t());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.p.k0(null);
            }
            pbCommenFloorItemViewHolder.p.setTextViewOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.p.setTextViewCheckSelection(false);
        }
    }

    public final void R(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.L) == null || this.l == null) {
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
    public final void S(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        boolean z2;
        int i2;
        int i3;
        ft7 ft7Var;
        ft7 ft7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        String str = null;
        boolean z3 = true;
        if (postData.B() > 0 && (ft7Var2 = this.l) != null && !ft7Var2.i0()) {
            String format = String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f097d), Integer.valueOf(postData.B()));
            pbCommenFloorItemViewHolder.G.setVisibility(0);
            pbCommenFloorItemViewHolder.G.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.G.setVisibility(8);
            z = false;
        }
        if (postData.s() != null) {
            str = postData.s().getIpAddress();
            if (!TextUtils.isEmpty(str)) {
                z2 = true;
                j15 R = postData.R();
                z3 = (R != null || StringUtils.isNull(R.b()) || (ft7Var = this.l) == null || ft7Var.i0()) ? false : false;
                if (!z) {
                    pbCommenFloorItemViewHolder.k.setVisibility(0);
                    i2 = this.g;
                } else {
                    pbCommenFloorItemViewHolder.k.setVisibility(8);
                    i2 = 0;
                }
                if (z3 && !z2) {
                    pbCommenFloorItemViewHolder.l.setVisibility(8);
                    i3 = 0;
                } else {
                    pbCommenFloorItemViewHolder.l.setVisibility(0);
                    i3 = this.g;
                }
                pbCommenFloorItemViewHolder.j.setPadding(i2, 0, i3, 0);
                if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTimeShort(postData.e0()));
                } else {
                    pbCommenFloorItemViewHolder.j.setText(StringHelper.getFormatTime(postData.e0()));
                }
                if (!z2) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    pbCommenFloorItemViewHolder.m.setPadding(this.g, 0, 0, 0);
                    TextView textView = pbCommenFloorItemViewHolder.m;
                    textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14e4) + str);
                } else if (z3) {
                    pbCommenFloorItemViewHolder.m.setVisibility(0);
                    pbCommenFloorItemViewHolder.m.setPadding(this.g, 0, 0, 0);
                    if (postData.Z) {
                        pbCommenFloorItemViewHolder.m.setText(StringHelper.cutStringWithSuffix(R.b(), 7, StringHelper.STRING_MORE));
                    } else {
                        pbCommenFloorItemViewHolder.m.setText(R.b());
                    }
                } else {
                    pbCommenFloorItemViewHolder.m.setVisibility(8);
                }
                TextView textView2 = pbCommenFloorItemViewHolder.g0;
                textView2.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
            }
        }
        z2 = false;
        j15 R2 = postData.R();
        if (R2 != null) {
        }
        if (!z) {
        }
        if (z3) {
        }
        pbCommenFloorItemViewHolder.l.setVisibility(0);
        i3 = this.g;
        pbCommenFloorItemViewHolder.j.setPadding(i2, 0, i3, 0);
        if (!StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
        }
        if (!z2) {
        }
        TextView textView22 = pbCommenFloorItemViewHolder.g0;
        textView22.setText(((Object) pbCommenFloorItemViewHolder.j.getText()) + "  • ");
    }

    public final void T(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.Y.setVisibility(postData.Z ? 0 : 8);
    }

    public final void U(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048590, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.x.setVisibility(8);
        pbCommenFloorItemViewHolder.r.setVisibility(0);
        pbCommenFloorItemViewHolder.f0.setVisibility(8);
        pbCommenFloorItemViewHolder.v.setVisibility(8);
        pbCommenFloorItemViewHolder.w.setVisibility(8);
        pbCommenFloorItemViewHolder.n.setVisibility(8);
        pbCommenFloorItemViewHolder.n0.setVisibility(8);
        d0(pbCommenFloorItemViewHolder, postData, view2, i2);
        R(pbCommenFloorItemViewHolder, postData);
        V(pbCommenFloorItemViewHolder, postData);
        Y(pbCommenFloorItemViewHolder, postData, view2);
        X(pbCommenFloorItemViewHolder, postData, view2, i2);
        S(pbCommenFloorItemViewHolder, postData);
        a0(pbCommenFloorItemViewHolder, postData);
        W(pbCommenFloorItemViewHolder, postData);
        b0(pbCommenFloorItemViewHolder, postData);
        Q(pbCommenFloorItemViewHolder, postData);
        T(pbCommenFloorItemViewHolder, postData);
        Z(pbCommenFloorItemViewHolder, postData);
        c0(pbCommenFloorItemViewHolder, postData);
        u0(pbCommenFloorItemViewHolder, postData);
        tu7.h(pbCommenFloorItemViewHolder, view2, postData, this.s, true);
    }

    public final void V(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
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
        if (threadData != null && threadData.isUgcThreadType()) {
            pbCommenFloorItemViewHolder.n.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.n.setThreadData(threadData);
        pbCommenFloorItemViewHolder.n.setData(postData.q());
        pbCommenFloorItemViewHolder.d0.setThreadData(threadData);
        pbCommenFloorItemViewHolder.d0.setData(postData.q());
    }

    public final void W(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.R == null || pbCommenFloorItemViewHolder.O == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.R) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.R.setText(postData.R.liveTitle);
            pbCommenFloorItemViewHolder.O.setTag(postData.R);
            pbCommenFloorItemViewHolder.O.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.O.setVisibility(8);
    }

    public final void X(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048593, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.a0() > 0) {
            pbCommenFloorItemViewHolder.u.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.u.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.u.setTag(sparseArray);
            }
            sparseArray.put(R.id.obfuscated_res_0x7f092005, postData);
            if (postData.F() == 2) {
                pbCommenFloorItemViewHolder.u.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.u.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.t.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.v;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.v.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.obfuscated_res_0x7f092005, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.w;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.w.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.obfuscated_res_0x7f092005, postData);
        }
        pbCommenFloorItemViewHolder.t.setVisibility(8);
        if (!postData.n0() && !postData.m0(false)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            layoutParams.topMargin = 0;
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
            layoutParams.bottomMargin = 0;
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams);
            pbCommenFloorItemViewHolder.s.setVisibility(8);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.s.getLayoutParams();
            layoutParams2.topMargin = qi.f(this.mContext, R.dimen.tbds10);
            layoutParams2.leftMargin = qi.f(this.mContext, R.dimen.tbds148);
            layoutParams2.rightMargin = qi.f(this.mContext, R.dimen.M_W_X007);
            layoutParams2.bottomMargin = qi.f(this.mContext, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.s.setLayoutParams(layoutParams2);
            if (this.r == null) {
                rz7 rz7Var = new rz7(this.mContext);
                this.r = rz7Var;
                rz7Var.f(this.e);
                this.r.h(this.m);
                this.r.e(this.n);
                String str = null;
                ft7 ft7Var = this.l;
                if (ft7Var != null && ft7Var.O() != null && this.l.O().getAuthor() != null) {
                    str = this.l.O().getAuthor().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                ft7 ft7Var2 = this.l;
                if (ft7Var2 != null) {
                    this.r.j(ft7Var2.W(), z);
                    this.r.i(this.l.O());
                }
            }
            this.r.g(postData.K());
            pbCommenFloorItemViewHolder.s.setSubPbAdapter(this.r);
            pbCommenFloorItemViewHolder.s.setVisibility(0);
            pbCommenFloorItemViewHolder.s.setData(postData, view2);
            pbCommenFloorItemViewHolder.s.setChildOnClickListener(this.n);
            pbCommenFloorItemViewHolder.s.setChildOnLongClickListener(this.q);
            pbCommenFloorItemViewHolder.s.setChildOnTouchListener(this.B);
        }
        if (postData.N) {
            pbCommenFloorItemViewHolder.M.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.M.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.u.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.r.getLayoutParams();
        layoutParams3.topMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = qi.f(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.t.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.r.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.r.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.h0.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fdd));
    }

    public final void Y(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, pbCommenFloorItemViewHolder, postData, view2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = qi.f(this.mContext, R.dimen.M_W_X007);
        layoutParams.leftMargin = qi.f(this.mContext, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.p.setPadding(0, 0, 0, 0);
        if (!this.i) {
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.p.k0(null);
            pbCommenFloorItemViewHolder.p.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.p.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f08120f);
        }
        pbCommenFloorItemViewHolder.p.getLayoutStrategy().x(R.drawable.pic_video);
        K(pbCommenFloorItemViewHolder.p, view2, !StringUtils.isNull(postData.t()));
        pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.p.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.p.setIsFromCDN(this.e);
        pbCommenFloorItemViewHolder.p.setText(postData.V(), true, this.h);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.p.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092001, Boolean.FALSE);
        sparseArray.put(R.id.obfuscated_res_0x7f092002, Boolean.FALSE);
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
        pbCommenFloorItemViewHolder.b.setTag(R.id.obfuscated_res_0x7f091ffb, sparseArray);
        pbCommenFloorItemViewHolder.n0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.e0.setTag(sparseArray);
    }

    public final void Z(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.b == null) {
            return;
        }
        t08 t08Var = this.a;
        if (t08Var != null && t08Var.K() != null && StringHelper.equals(this.a.K().r1(), postData.K())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.b0() != null) {
                TbRichText V = postData.V();
                v18.c(postData.b0(), pbCommenFloorItemViewHolder.N, false, false, V != null && StringUtils.isNull(V.toString()) && StringUtils.isNull(postData.t()));
                return;
            }
            pbCommenFloorItemViewHolder.N.setVisibility(8);
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.F() != 2 && postData.F() != 4) {
                pbCommenFloorItemViewHolder.U.setVisibility(8);
                pbCommenFloorItemViewHolder.T.setVisibility(0);
                M(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.U.setOnClickListener(new f(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.U.setVisibility(0);
                L(pbCommenFloorItemViewHolder, postData.q0(), postData.E());
                M(true, pbCommenFloorItemViewHolder, postData);
            }
            l0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.i = z;
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048599, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.f(postData.Q, postData.K(), this.w);
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onLongClickListener) == null) {
            this.q = onLongClickListener;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x07cb  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0822  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x082c  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0892  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x089c  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x08db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i2) {
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048601, this, pbCommenFloorItemViewHolder, postData, view2, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
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
        pbCommenFloorItemViewHolder.o.setTag(null);
        pbCommenFloorItemViewHolder.o.setUserId(null);
        pbCommenFloorItemViewHolder.I.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.p.setIsHost(false);
        if (postData.s() != null) {
            String str = this.k;
            if (str != null && !str.equals("0") && this.k.equals(postData.s().getUserId())) {
                pbCommenFloorItemViewHolder.p.setIsHost(true);
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
            if (pbCommenFloorItemViewHolder.J != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.J.setTag(tShowInfoNew.get(0).getUrl());
                }
                t08 t08Var = this.a;
                if (t08Var != null && t08Var.P() != null) {
                    pbCommenFloorItemViewHolder.J.setOnClickListener(this.a.P().d.e);
                }
                int f4 = qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.J.h(tShowInfoNew, 3, f4, f4, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.s().isBigV()) {
                if (UbsABTestHelper.isPBPlanA()) {
                    if (DeviceInfoUtil.isMate30()) {
                        lx7.n(pbCommenFloorItemViewHolder.f);
                    } else {
                        ms4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
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
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092045, postData.s().getUserName());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092033, i08.i(this.l, postData, postData.b0, i4, 2));
            String name_show = postData.s().getName_show();
            String userName = postData.s().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.g.setText(gs7.b(this.mContext, pbCommenFloorItemViewHolder.f.getText().toString()));
                pbCommenFloorItemViewHolder.f.setGravity(16);
                pbCommenFloorItemViewHolder.f.setTag(R.id.obfuscated_res_0x7f092012, gs7.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0312, 1);
            }
            if (postData.s().getPendantData() != null && !StringUtils.isNull(postData.s().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.I.setBigVDimenSize(R.dimen.tbds36);
                pbCommenFloorItemViewHolder.I.j(postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setVisibility(8);
                pbCommenFloorItemViewHolder.I.setVisibility(0);
                pbCommenFloorItemViewHolder.I.getHeadView().K(avater, 28, false);
                pbCommenFloorItemViewHolder.I.getHeadView().setUserId(postData.s().getUserId());
                pbCommenFloorItemViewHolder.I.getHeadView().setUserName(postData.s().getUserName());
                ft7 ft7Var = this.l;
                pbCommenFloorItemViewHolder.I.getHeadView().setFid(ft7Var != null ? ft7Var.m() : "");
                ft7 ft7Var2 = this.l;
                pbCommenFloorItemViewHolder.I.getHeadView().setFName(ft7Var2 != null ? ft7Var2.n() : "");
                pbCommenFloorItemViewHolder.I.getHeadView().setFloor(postData.B());
                pbCommenFloorItemViewHolder.I.getHeadView().setTid(postData.K());
                pbCommenFloorItemViewHolder.I.getHeadView().setTag(R.id.obfuscated_res_0x7f092033, i08.i(this.l, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.I.m(postData.s().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.o.setGodIconWidth(R.dimen.tbds36);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.o, postData.s(), 4);
                pbCommenFloorItemViewHolder.o.setUserId(postData.s().getUserId());
                ft7 ft7Var3 = this.l;
                pbCommenFloorItemViewHolder.o.setFid(ft7Var3 != null ? ft7Var3.m() : "");
                ft7 ft7Var4 = this.l;
                pbCommenFloorItemViewHolder.o.setFName(ft7Var4 != null ? ft7Var4.n() : "");
                pbCommenFloorItemViewHolder.o.setFloor(postData.B());
                pbCommenFloorItemViewHolder.o.setTid(postData.K());
                pbCommenFloorItemViewHolder.o.setUserName(postData.s().getUserName(), postData.g0());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092047, postData.s().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.o.setTag(R.id.obfuscated_res_0x7f092033, i08.i(this.l, postData, postData.b0, i4, 2));
                pbCommenFloorItemViewHolder.o.setImageDrawable(null);
                pbCommenFloorItemViewHolder.o.K(avater, 28, false);
                pbCommenFloorItemViewHolder.o.setVisibility(0);
                pbCommenFloorItemViewHolder.I.setVisibility(8);
            }
            if (postData.s() != null && postData.s().getAlaInfo() != null && postData.s().getAlaUserData() != null && postData.s().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.d(true);
                pbCommenFloorItemViewHolder.o.setLiveStatus(1);
                pbCommenFloorItemViewHolder.o.setAlaInfo(postData.s().getAlaInfo());
                pbCommenFloorItemViewHolder.I.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.I.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.d(false);
                pbCommenFloorItemViewHolder.o.setLiveStatus(0);
                pbCommenFloorItemViewHolder.o.setAlaInfo(null);
                pbCommenFloorItemViewHolder.I.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.I.getHeadView().setAlaInfo(null);
            }
            w0(pbCommenFloorItemViewHolder.h, postData);
            if (TbSingleton.getInstance().isUserGrowthOpen() && postData.s().getUserGrowthData() != null) {
                int a2 = postData.s().getUserGrowthData().a();
                if (a2 > 0 && a2 <= 10) {
                    pbCommenFloorItemViewHolder.i.K(String.valueOf(vw.b(a2)), 24, false);
                    pbCommenFloorItemViewHolder.i.setVisibility(0);
                } else {
                    pbCommenFloorItemViewHolder.i.setVisibility(8);
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
            pbCommenFloorItemViewHolder.H.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.H, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.H.setVisibility(8);
        }
        int i5 = 15;
        if (i3 == 1) {
            i5 = 13;
        } else if (i3 > 1) {
            i5 = 11;
        }
        if (pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
            i5 -= 2;
        }
        if (pbCommenFloorItemViewHolder.J.getChildCount() > 0) {
            i5 -= 2;
        }
        if (postData.x() > 1000) {
            i5 -= 2;
        }
        if (postData.x() > 10) {
            i5 -= 2;
        }
        if (i5 < 10) {
            if (i3 == 1) {
                i5 += 2;
            } else if (i3 > 1) {
                i5 += 4;
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.h.getVisibility() == 0) {
                i5 += 2;
                pbCommenFloorItemViewHolder.h.setVisibility(8);
            }
            if (i5 < 10 && pbCommenFloorItemViewHolder.H.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.H.setVisibility(8);
            }
        }
        int e2 = lx7.e();
        String[] strArr = new String[1];
        strArr[0] = (postData.s() == null || postData.s().getName_show() == null) ? "" : postData.s().getName_show();
        int d2 = if5.d(strArr[0]);
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            int i6 = e2 - 2;
            if (d2 > i6) {
                strArr[0] = if5.n(strArr[0], i6);
                strArr[0] = strArr[0] + StringHelper.STRING_MORE;
            }
        } else if (d2 > e2) {
            strArr[0] = if5.n(strArr[0], e2);
            strArr[0] = strArr[0] + StringHelper.STRING_MORE;
        }
        if (postData.s() != null && !StringUtils.isNull(postData.s().getSealPrefix())) {
            pbCommenFloorItemViewHolder.g.setText(f0(postData.s().getSealPrefix(), strArr[0]));
        } else {
            pbCommenFloorItemViewHolder.g.setText(strArr[0]);
        }
        if (((PostData) getItem(i2)).N() == 1 && this.l.O() != null && this.l.O().isQuestionThread() && !N(postData)) {
            ((PostData) getItem(i2)).H0(true);
            pbCommenFloorItemViewHolder.x0.setVisibility(0);
            if (((PostData) getItem(i2)).M().booleanValue()) {
                pbCommenFloorItemViewHolder.y0.setVisibility(0);
                pbCommenFloorItemViewHolder.d0.setVisibility(8);
                pbCommenFloorItemViewHolder.y0.postDelayed(new g(this, pbCommenFloorItemViewHolder), 3000L);
            } else {
                pbCommenFloorItemViewHolder.y0.setVisibility(8);
                pbCommenFloorItemViewHolder.d0.setVisibility(0);
            }
        } else {
            ((PostData) getItem(i2)).H0(false);
            pbCommenFloorItemViewHolder.x0.setVisibility(8);
            pbCommenFloorItemViewHolder.y0.setVisibility(8);
            pbCommenFloorItemViewHolder.d0.setVisibility(0);
        }
        SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.x0, R.color.CAM_X0204);
        SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.w0, R.color.CAM_X0105, 1);
        pbCommenFloorItemViewHolder.e.post(new h(this, pbCommenFloorItemViewHolder, postData, new String[]{strArr[0]}, 2));
        if (!StringUtils.isNull(postData.s().getDiplayIntro())) {
            pbCommenFloorItemViewHolder.z0.setVisibility(0);
            pbCommenFloorItemViewHolder.z0.setText(postData.s().getDiplayIntro() + "");
        } else {
            pbCommenFloorItemViewHolder.z0.setVisibility(8);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.obfuscated_res_0x7f091fe8, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092005, postData);
        sparseArray.put(R.id.obfuscated_res_0x7f092007, view2);
        sparseArray.put(R.id.obfuscated_res_0x7f092016, Integer.valueOf(i2));
        sparseArray.put(R.id.obfuscated_res_0x7f092015, Integer.valueOf(postData.B()));
        sparseArray.put(R.id.obfuscated_res_0x7f091ff8, postData.K());
        sparseArray.put(R.id.obfuscated_res_0x7f0917b8, pbCommenFloorItemViewHolder.n);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b9, pbCommenFloorItemViewHolder.d0);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b6, pbCommenFloorItemViewHolder.v);
        sparseArray.put(R.id.obfuscated_res_0x7f0917b7, pbCommenFloorItemViewHolder.w);
        ft7 ft7Var6 = this.l;
        ThreadData O = (ft7Var6 == null || ft7Var6.O() == null) ? null : this.l.O();
        if (O != null && O.isUgcThreadType()) {
            sparseArray.put(R.id.obfuscated_res_0x7f0917b5, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.obfuscated_res_0x7f0917b5, Boolean.FALSE);
        }
        boolean z8 = (postData.s() == null || StringUtils.isNull(postData.s().getVirtualUserUrl())) ? false : true;
        ft7 ft7Var7 = this.l;
        if (ft7Var7 == null || ft7Var7.W() == 0 || h0()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z = (this.l.W() == 1002 || this.l.W() == 3) ? false : true;
            if (this.l.W() == 3 || this.l.i0()) {
                z2 = false;
                z3 = false;
            } else {
                z2 = true;
                z3 = true;
            }
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
                    z5 = false;
                    z4 = true;
                    z6 = true;
                } else {
                    z5 = true;
                    z4 = true;
                    z6 = false;
                }
                z7 = true;
                if (postData != null && postData.s() != null && UtilHelper.isCurrentAccount(postData.s().getUserId())) {
                    z4 = true;
                    z6 = true;
                }
                if (z8) {
                    z = false;
                    z5 = false;
                    z4 = false;
                }
                int i7 = postData.B() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(this.l.W()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff5, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff6, postData.s().getName_show());
                        sparseArray.put(R.id.obfuscated_res_0x7f091ff7, postData.s().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092030, Boolean.FALSE);
                }
                if (!z5) {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091fff, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.s() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092040, postData.s().getUserId());
                        sparseArray.put(R.id.obfuscated_res_0x7f092041, postData.s().getUserName());
                        sparseArray.put(R.id.obfuscated_res_0x7f09203f, postData.s().getName_show());
                    }
                    if (this.l.O() != null) {
                        sparseArray.put(R.id.obfuscated_res_0x7f092043, this.l.O().getId());
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f092042, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f092044, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.obfuscated_res_0x7f09202e, Boolean.TRUE);
                    sparseArray.put(R.id.obfuscated_res_0x7f091ffc, Boolean.valueOf(postData.n0()));
                    sparseArray.put(R.id.obfuscated_res_0x7f092008, Integer.valueOf(this.l.W()));
                    sparseArray.put(R.id.obfuscated_res_0x7f091feb, Boolean.valueOf(z6));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fec, Integer.valueOf(i7));
                    sparseArray.put(R.id.obfuscated_res_0x7f091fea, postData.K());
                } else {
                    sparseArray.put(R.id.obfuscated_res_0x7f09202e, Boolean.FALSE);
                }
                sparseArray.put(R.id.obfuscated_res_0x7f092009, Boolean.valueOf(z3));
                sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z7));
                pbCommenFloorItemViewHolder.p.setTag(sparseArray);
            }
        }
        z4 = z2;
        z5 = false;
        z6 = false;
        z7 = false;
        if (postData != null) {
            z4 = true;
            z6 = true;
        }
        if (z8) {
        }
        if (postData.B() != 1) {
        }
        if (!z) {
        }
        if (!z5) {
        }
        if (!z4) {
        }
        sparseArray.put(R.id.obfuscated_res_0x7f092009, Boolean.valueOf(z3));
        sparseArray.put(R.id.obfuscated_res_0x7f092000, Boolean.valueOf(z7));
        pbCommenFloorItemViewHolder.p.setTag(sparseArray);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, onClickListener) == null) {
            this.n = onClickListener;
        }
    }

    public final boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ft7 ft7Var = this.l;
            if (ft7Var == null || ft7Var.O() == null) {
                return false;
            }
            return this.l.O().isQuestionThread();
        }
        return invokeV.booleanValue;
    }

    public final SpannableStringBuilder f0(String str, String str2) {
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

    public final String g0(View view2) {
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

    public final boolean h0() {
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

    public void i0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, metaData) == null) {
            PersonalChatActivityConfig personalChatActivityConfig = new PersonalChatActivityConfig(this.mContext, metaData.getUserIdLong(), metaData.getUserName(), metaData.getName_show(), metaData.getPortrait(), metaData.getGender(), metaData.getIsMyFriend());
            personalChatActivityConfig.setFrom(3);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002005, personalChatActivityConfig));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bn
    /* renamed from: j0 */
    public PbCommenFloorItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06ca, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f091834)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d06c2, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.a.P().getPageContext(), inflate, this.u);
            pbCommenFloorItemViewHolder.q.setConstrainLayoutPool(this.z);
            pbCommenFloorItemViewHolder.q.setImageViewPool(this.A);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.s;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.v);
                pbCommenFloorItemViewHolder.s.setIsVideoThread(false);
            }
            t0(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.p;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.t);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.m = onClickListener;
        }
    }

    public View k0(int i2, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Integer.valueOf(i2), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.onFillViewHolder(i2, view2, viewGroup, postData, pbCommenFloorItemViewHolder);
            t0(pbCommenFloorItemViewHolder);
            o0(pbCommenFloorItemViewHolder, i2);
            F(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) getItem(i2);
            if (postData2 != null) {
                postData2.b0 = i2 + 1;
                H(postData2);
                G(postData2);
                postData2.h1();
                P(postData2);
                U(pbCommenFloorItemViewHolder, postData2, view2, i2);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText V = postData.V();
            V.isChanged = true;
            pbCommenFloorItemViewHolder.p.setText(V, true, this.h);
        }
    }

    public final void m0(PostData postData) {
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

    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, yVar) == null) {
            this.o = yVar;
        }
    }

    public void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048614, this, z) == null) {
            this.t = z;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.k = str;
        }
    }

    public final void o0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048616, this, pbCommenFloorItemViewHolder, i2) == null) {
            pbCommenFloorItemViewHolder.b.setOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.q);
            if (this.a.P() == null || this.a.P().getPageContext() == null || this.a.P().getPageContext().getOrignalPage() == null) {
                return;
            }
            ry7 ry7Var = this.a.P().d;
            pbCommenFloorItemViewHolder.f.setOnClickListener(ry7Var.b);
            pbCommenFloorItemViewHolder.o.setOnClickListener(ry7Var.b);
            pbCommenFloorItemViewHolder.t0.setOnClickListener(ry7Var.d);
            pbCommenFloorItemViewHolder.s0.setOnClickListener(ry7Var.d);
            pbCommenFloorItemViewHolder.I.setOnClickListener(ry7Var.b);
            pbCommenFloorItemViewHolder.I.getHeadView().setOnClickListener(ry7Var.b);
            pbCommenFloorItemViewHolder.p.setOnLongClickListener(this.q);
            pbCommenFloorItemViewHolder.p.setOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.p.setCommonTextViewOnClickListener(this.n);
            pbCommenFloorItemViewHolder.p.setOnImageClickListener(this.o);
            pbCommenFloorItemViewHolder.p.setOnImageTouchListener(this.B);
            pbCommenFloorItemViewHolder.p.setOnEmotionClickListener(ry7Var.f);
            pbCommenFloorItemViewHolder.p.setOnVoiceAfterClickListener(this.n);
            pbCommenFloorItemViewHolder.N.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.O.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.t.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.u.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.i0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.m0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.m0.setOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.e0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.n0.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.f0.setOnClickListener(new i(this, pbCommenFloorItemViewHolder));
            ty7 ty7Var = this.a.P().e;
            pbCommenFloorItemViewHolder.v.setOnClickListener(this.n);
            pbCommenFloorItemViewHolder.w.setOnClickListener(new j(this, pbCommenFloorItemViewHolder, ty7Var));
            pbCommenFloorItemViewHolder.n.x = new k(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.d0.x = new a(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.d0.setAfterClickListener(new b(this, i2, pbCommenFloorItemViewHolder));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, view2) == null) {
        }
    }

    @Override // com.repackage.bw7, com.repackage.bn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i2, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        k0(i2, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048620, this, z) == null) {
            this.w = z;
        }
    }

    public void q0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.s = z;
        }
    }

    public void r(ft7 ft7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, ft7Var) == null) {
            this.l = ft7Var;
        }
    }

    public void r0(hu7 hu7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, hu7Var) == null) {
            this.p = hu7Var;
        }
    }

    public void s0(TbRichTextView.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, sVar) == null) {
            this.h = sVar;
        }
    }

    public final void t0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.a != skinType) {
            v0(pbCommenFloorItemViewHolder.h);
            if (UbsABTestHelper.isPBPlanA()) {
                if (DeviceInfoUtil.isMate30()) {
                    lx7.n(pbCommenFloorItemViewHolder.f);
                } else {
                    ms4.d(pbCommenFloorItemViewHolder.f).A(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.l, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.G, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.m, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.u, (int) R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.p.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.g0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.h0, R.color.CAM_X0107, 1);
            SkinManager.setBackgroundShapeDrawable(pbCommenFloorItemViewHolder.s, qi.f(TbadkCoreApplication.getInst(), R.dimen.tbds21), R.color.CAM_X0206, R.color.CAM_X0206);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.t, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.t, (int) R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.t.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.v, R.drawable.obfuscated_res_0x7f08098a, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.w, R.drawable.obfuscated_res_0x7f08098b, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.s.d();
            pbCommenFloorItemViewHolder.q.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.R, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.P, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.O, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.Q, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.S, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.V, (int) R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.T.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f03f6);
            } else {
                ft7 ft7Var = this.l;
                if (ft7Var != null && StringUtils.isNull(ft7Var.k())) {
                    pbCommenFloorItemViewHolder.V.setText(this.l.k());
                } else {
                    pbCommenFloorItemViewHolder.V.setText(R.string.obfuscated_res_0x7f0f05d8);
                }
            }
            pbCommenFloorItemViewHolder.n.K(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.c(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.e0, R.drawable.obfuscated_res_0x7f080965, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.n0, R.drawable.obfuscated_res_0x7f080965, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.b();
        }
        pbCommenFloorItemViewHolder.a = skinType;
    }

    public void u0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048626, this, pbCommenFloorItemViewHolder, postData) == null) {
            String str = "#7F66FE";
            if (postData.i0() != null) {
                VirtualImageCustomFigure i0 = postData.i0();
                pbCommenFloorItemViewHolder.t0.setHeadImageViewResource(i0.getFigureUrl());
                pbCommenFloorItemViewHolder.t0.setTid(postData.K());
                pbCommenFloorItemViewHolder.t0.setLocate(px7.c);
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(i0.getBackGroundType())) {
                    str = i0.getBackgroundValue();
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundColorResource(i0.getBackgroundValue());
                } else if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(i0.getBackGroundType())) {
                    pbCommenFloorItemViewHolder.t0.setHeadImageBackgroundResource(i0.getBackgroundValue());
                }
                pbCommenFloorItemViewHolder.t0.d(postData.s());
                pbCommenFloorItemViewHolder.r0.setVisibility(8);
                pbCommenFloorItemViewHolder.u0.setVisibility(0);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f092045, postData.s().getUserName());
            } else {
                pbCommenFloorItemViewHolder.u0.setVisibility(8);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f09203d, null);
                pbCommenFloorItemViewHolder.t0.setTag(R.id.obfuscated_res_0x7f092045, null);
                pbCommenFloorItemViewHolder.r0.setVisibility(0);
            }
            if (postData.j0() != null && !TextUtils.isEmpty(postData.j0().b())) {
                pbCommenFloorItemViewHolder.s0.setData(postData.j0().b(), null, str);
                pbCommenFloorItemViewHolder.s0.setVisibility(0);
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams.setMargins(-UtilHelper.getDimenPixelSize(R.dimen.tbds20), marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams);
                }
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f09203d, postData.s().getUserId());
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f092045, postData.s().getUserName());
                this.x = px7.d;
                this.y = pbCommenFloorItemViewHolder.s0.getData();
                pbCommenFloorItemViewHolder.t0.setWithBubble(this.x);
                pbCommenFloorItemViewHolder.t0.setBubbleName(this.y);
            } else {
                if (pbCommenFloorItemViewHolder.v0.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) pbCommenFloorItemViewHolder.v0.getLayoutParams();
                    marginLayoutParams2.setMargins(0, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                    pbCommenFloorItemViewHolder.v0.setLayoutParams(marginLayoutParams2);
                }
                pbCommenFloorItemViewHolder.s0.setVisibility(8);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f092045, null);
                pbCommenFloorItemViewHolder.s0.setTag(R.id.obfuscated_res_0x7f09203d, null);
                int i2 = px7.e;
                this.x = i2;
                pbCommenFloorItemViewHolder.t0.setWithBubble(i2);
            }
            if (pbCommenFloorItemViewHolder.t0.getVisibility() == 0) {
                pbCommenFloorItemViewHolder.t0.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            }
            if (postData.i0() != null) {
                px7.a(2, postData.K(), px7.c, this.x, this.y);
            }
        }
    }

    public final void v0(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            w0(textView, (PostData) tag);
        }
    }

    public final void w0(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048628, this, textView, postData) == null) {
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
