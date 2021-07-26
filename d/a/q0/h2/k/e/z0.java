package d.a.q0.h2.k.e;

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
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.DeviceInfoUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
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
import d.a.p0.s.q.b2;
import d.a.q0.a0.m;
import d.a.q0.h2.i.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class z0 extends o<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbRichTextView.z A;
    public d.a.q0.h2.i.c B;
    public View.OnLongClickListener C;
    public d.a.q0.h2.k.g.b D;
    public int E;
    public boolean F;
    public int G;
    public boolean H;
    public boolean I;
    public d.a.d.e.k.b<ConstrainImageLayout> J;
    public d.a.d.e.k.b<TbImageView> K;
    public d.a.q0.h2.i.c L;
    public int s;
    public TbRichTextView.t t;
    public boolean u;
    public float v;
    public String w;
    public d.a.q0.h2.h.e x;
    public View.OnClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes8.dex */
    public class a implements d.a.d.e.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z0 f58120a;

        public a(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58120a = z0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
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
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f58120a.f42341e) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.d.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z0 f58121a;

        public b(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58121a = z0Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.d.e.k.c
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
        @Override // d.a.d.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.d.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f58121a.f42341e);
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
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

    /* loaded from: classes8.dex */
    public class c implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ z0 f58122a;

        public c(z0 z0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58122a = z0Var;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f58122a.B != null) {
                    if (!(view instanceof TbListTextView) || this.f58122a.z == null) {
                        this.f58122a.B.a(view);
                        this.f58122a.B.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.f58122a.z.onClick(view);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.q0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (view == null || !((pbFragment = this.f58122a.n) == null || pbFragment.V4() == null || this.f58122a.n.V4().p1())) {
                    return true;
                }
                if (view instanceof RelativeLayout) {
                    this.f58122a.z0(view);
                } else {
                    ViewParent parent = view.getParent();
                    int i2 = 0;
                    while (true) {
                        if (parent == null || i2 >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.f58122a.z0((RelativeLayout) parent);
                            break;
                        } else {
                            parent = parent.getParent();
                            i2++;
                        }
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f58123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f58124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z0 f58125g;

        public d(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58125g = z0Var;
            this.f58123e = pbCommenFloorItemViewHolder;
            this.f58124f = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = this.f58123e.Q.getVisibility() == 8;
                this.f58125g.w0(this.f58123e, !z, this.f58124f.B());
                this.f58124f.m0(!z);
                this.f58125g.U0(this.f58123e, this.f58124f);
                PbFragment pbFragment = this.f58125g.n;
                if (pbFragment == null || pbFragment.V4() == null || this.f58125g.n.V4().U0() == null || this.f58125g.n.V4().B0() == null || z || this.f58123e.a().getTop() >= this.f58125g.n.V4().U0().getMeasuredHeight()) {
                    return;
                }
                this.f58125g.n.V4().B0().setSelectionFromTop(ListUtils.getPosition(this.f58125g.n.V4().B0().getData(), this.f58124f) + this.f58125g.n.V4().B0().getHeaderViewsCount(), this.f58125g.n.V4().U0().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f58126e;

        public e(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58126e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f58126e.s.performClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f58127e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.h2.k.e.d1.c f58128f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ z0 f58129g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f58130e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f58131f;

            public a(f fVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f58131f = fVar;
                this.f58130e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.f58131f;
                    fVar.f58128f.f57781b.a(fVar.f58129g.x, null, this.f58130e, fVar.f58127e.m.getLayoutStrategy());
                }
            }
        }

        public f(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, d.a.q0.h2.k.e.d1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58129g = z0Var;
            this.f58127e = pbCommenFloorItemViewHolder;
            this.f58128f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f58127e.f19287b == null || this.f58128f == null) {
                    return;
                }
                d.a.d.e.m.e.a().postDelayed(new a(this, postData), 100L);
                String P = this.f58129g.x.P();
                if ((StringUtils.isNull(P) || "0".equals(this.f58129g.x.P())) && this.f58129g.x.N() != null) {
                    P = this.f58129g.x.N().B0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.f58129g.x.n()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", this.f58129g.R0(view)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f58132e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ z0 f58133f;

        public g(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58133f = z0Var;
            this.f58132e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f58133f.x == null || (pbCommenFloorItemViewHolder = this.f58132e) == null || (agreeView = pbCommenFloorItemViewHolder.k) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f58132e.k.getImgAgree() ? 1 : 2;
            String P = this.f58133f.x.P();
            if ((StringUtils.isNull(P) || "0".equals(this.f58133f.x.P())) && this.f58133f.x.N() != null) {
                P = this.f58133f.x.N().B0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.f58133f.x.n()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f58132e.k.getData().postId).param("obj_source", this.f58133f.R0(this.f58132e.k)).param("obj_type", i2));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.f58133f.x.n());
            statisticItem.param("tid", this.f58133f.x.P());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.f58133f.x.j().E());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", this.f58133f.P0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f58134e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ z0 f58135f;

        public h(z0 z0Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {z0Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f58135f = z0Var;
            this.f58134e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f58135f.x == null || (pbCommenFloorItemViewHolder = this.f58134e) == null || (agreeView = pbCommenFloorItemViewHolder.Y) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f58134e.Y.getImgAgree() ? 1 : 2;
            String P = this.f58135f.x.P();
            if ((StringUtils.isNull(P) || "0".equals(this.f58135f.x.P())) && this.f58135f.x.N() != null) {
                P = this.f58135f.x.N().B0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.f58135f.x.n()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f58134e.Y.getData().postId).param("obj_source", this.f58135f.R0(this.f58134e.Y)).param("obj_type", i2));
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
            statisticItem.param("fid", this.f58135f.x.n());
            statisticItem.param("tid", this.f58135f.x.P());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("post_id", this.f58135f.x.j().E());
            statisticItem.param("obj_source", 1);
            statisticItem.param("obj_type", 1);
            statisticItem.param("obj_locate", this.f58135f.P0());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z0(d.a.q0.h2.o.b bVar, BdUniqueId bdUniqueId) {
        super(bVar, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.q0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        this.t = null;
        this.u = true;
        this.v = 1.0f;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.F = true;
        this.H = true;
        this.I = false;
        this.J = new d.a.d.e.k.b<>(new a(this), 6, 0);
        this.K = new d.a.d.e.k.b<>(new b(this), 12, 0);
        this.L = new d.a.q0.h2.i.c(new c(this));
        if (bVar != null && bVar.y() != null) {
            this.G = bVar.y().K0();
        }
        this.s = e0(R.dimen.tbds14);
    }

    public final void A0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = d.a.q0.h2.m.a.i(this.x, postData, postData.i0, postData.c0 ? 2 : 8, 6);
        postData.j0 = i2;
        if (ListUtils.isEmpty(postData.M())) {
            return;
        }
        Iterator<PostData> it = postData.M().iterator();
        while (it.hasNext()) {
            it.next().j0 = i2;
        }
    }

    public final void B0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.u()) && this.u) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
                layoutParams.topMargin = e0(R.dimen.ds20);
                layoutParams.bottomMargin = e0(R.dimen.ds20);
                pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.m.h0(postData.u());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.m.h0(null);
            }
            pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.L);
            pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
        }
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.I) == null || this.x == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        int i3;
        d.a.q0.h2.h.e eVar;
        d.a.q0.h2.h.e eVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && (eVar2 = this.x) != null && !eVar2.e0()) {
            String format = String.format(this.f42341e.getString(R.string.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
            z = false;
        }
        d.a.p0.u.f I = postData.I();
        z2 = (I == null || StringUtils.isNull(I.b()) || (eVar = this.x) == null || eVar.e0()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.f19293h.setVisibility(0);
            i2 = this.s;
        } else {
            pbCommenFloorItemViewHolder.f19293h.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.f19294i.setVisibility(0);
            i3 = this.s;
        } else {
            pbCommenFloorItemViewHolder.f19294i.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.f19292g.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
            pbCommenFloorItemViewHolder.f19292g.setText(StringHelper.getFormatTimeShort(postData.R()));
        } else {
            pbCommenFloorItemViewHolder.f19292g.setText(StringHelper.getFormatTime(postData.R()));
        }
        if (z2) {
            pbCommenFloorItemViewHolder.j.setVisibility(0);
            pbCommenFloorItemViewHolder.j.setPadding(this.s, 0, 0, 0);
            if (postData.b0) {
                pbCommenFloorItemViewHolder.j.setText(StringHelper.cutStringWithSuffix(I.b(), 7, StringHelper.STRING_MORE));
            } else {
                pbCommenFloorItemViewHolder.j.setText(I.b());
            }
        } else {
            pbCommenFloorItemViewHolder.j.setVisibility(8);
        }
        TextView textView = pbCommenFloorItemViewHolder.b0;
        textView.setText(((Object) pbCommenFloorItemViewHolder.f19292g.getText()) + "  • ");
    }

    public final void E0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.T.setVisibility(postData.b0 ? 0 : 8);
    }

    public final void F0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048581, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.u.setVisibility(8);
        pbCommenFloorItemViewHolder.X.setVisibility(0);
        pbCommenFloorItemViewHolder.o.setVisibility(0);
        pbCommenFloorItemViewHolder.a0.setVisibility(8);
        pbCommenFloorItemViewHolder.s.setVisibility(8);
        pbCommenFloorItemViewHolder.t.setVisibility(8);
        pbCommenFloorItemViewHolder.k.setVisibility(8);
        pbCommenFloorItemViewHolder.d0.setVisibility(8);
        O0(pbCommenFloorItemViewHolder, postData, view, i2);
        C0(pbCommenFloorItemViewHolder, postData);
        G0(pbCommenFloorItemViewHolder, postData);
        J0(pbCommenFloorItemViewHolder, postData, view);
        I0(pbCommenFloorItemViewHolder, postData, view, i2);
        D0(pbCommenFloorItemViewHolder, postData);
        L0(pbCommenFloorItemViewHolder, postData);
        H0(pbCommenFloorItemViewHolder, postData);
        M0(pbCommenFloorItemViewHolder, postData);
        B0(pbCommenFloorItemViewHolder, postData);
        E0(pbCommenFloorItemViewHolder, postData);
        K0(pbCommenFloorItemViewHolder, postData);
        N0(pbCommenFloorItemViewHolder, postData);
    }

    public final void G0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || postData.q() == null) {
            return;
        }
        postData.q().threadId = this.m.y().b1();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        b2 b2Var = null;
        d.a.q0.h2.h.e eVar = this.x;
        if (eVar != null && eVar.N() != null) {
            b2Var = this.x.N();
        }
        if (b2Var != null && b2Var.r2()) {
            pbCommenFloorItemViewHolder.k.setAgreeAlone(true);
        }
        pbCommenFloorItemViewHolder.k.setThreadData(b2Var);
        pbCommenFloorItemViewHolder.k.setData(postData.q());
        pbCommenFloorItemViewHolder.Y.setThreadData(b2Var);
        pbCommenFloorItemViewHolder.Y.setData(postData.q());
    }

    public final void H0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        AlaLiveInfoCoreData alaLiveInfoCoreData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.O == null || pbCommenFloorItemViewHolder.L == null) {
            return;
        }
        if (postData != null && (alaLiveInfoCoreData = postData.T) != null && !StringUtils.isNull(alaLiveInfoCoreData.liveTitle)) {
            pbCommenFloorItemViewHolder.O.setText(postData.T.liveTitle);
            pbCommenFloorItemViewHolder.L.setTag(postData.T);
            pbCommenFloorItemViewHolder.L.setVisibility(0);
            StatisticItem statisticItem = new StatisticItem("c12639");
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            }
            TiebaStatic.log(statisticItem);
            return;
        }
        pbCommenFloorItemViewHolder.L.setVisibility(8);
    }

    public final void I0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.N() > 0) {
            pbCommenFloorItemViewHolder.r.setVisibility(8);
        } else {
            SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.r.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                pbCommenFloorItemViewHolder.r.setTag(sparseArray);
            }
            sparseArray.put(R.id.tag_load_sub_data, postData);
            if (postData.C() == 2) {
                pbCommenFloorItemViewHolder.r.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.r.setVisibility(0);
            }
            pbCommenFloorItemViewHolder.q.setVisibility(8);
        }
        ImageView imageView = pbCommenFloorItemViewHolder.s;
        if (imageView != null) {
            SparseArray sparseArray2 = (SparseArray) imageView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                pbCommenFloorItemViewHolder.s.setTag(sparseArray2);
            }
            sparseArray2.put(R.id.tag_load_sub_data, postData);
        }
        ImageView imageView2 = pbCommenFloorItemViewHolder.t;
        if (imageView2 != null) {
            SparseArray sparseArray3 = (SparseArray) imageView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                pbCommenFloorItemViewHolder.t.setTag(sparseArray3);
            }
            sparseArray3.put(R.id.tag_load_sub_data, postData);
        }
        pbCommenFloorItemViewHolder.q.setVisibility(8);
        if (postData.W()) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
            layoutParams.topMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds10);
            layoutParams.leftMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds148);
            layoutParams.rightMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.M_W_X007);
            layoutParams.bottomMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
            if (this.D == null) {
                d.a.q0.h2.k.g.b bVar = new d.a.q0.h2.k.g.b(this.f42341e);
                this.D = bVar;
                bVar.f(this.q);
                this.D.h(this.y);
                this.D.e(this.z);
                String str = null;
                d.a.q0.h2.h.e eVar = this.x;
                if (eVar != null && eVar.N() != null && this.x.N().H() != null) {
                    str = this.x.N().H().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                d.a.q0.h2.h.e eVar2 = this.x;
                if (eVar2 != null) {
                    this.D.j(eVar2.U(), z);
                    this.D.i(this.x.N());
                }
            }
            this.D.g(postData.E());
            pbCommenFloorItemViewHolder.p.setSubPbAdapter(this.D);
            pbCommenFloorItemViewHolder.p.setVisibility(0);
            pbCommenFloorItemViewHolder.p.setData(postData, view);
            pbCommenFloorItemViewHolder.p.setChildOnClickListener(this.z);
            pbCommenFloorItemViewHolder.p.setChildOnLongClickListener(this.C);
            pbCommenFloorItemViewHolder.p.setChildOnTouchListener(this.L);
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.p.getLayoutParams();
            layoutParams2.topMargin = 0;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            layoutParams2.bottomMargin = 0;
            pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.p.setVisibility(8);
        }
        if (postData.P) {
            pbCommenFloorItemViewHolder.J.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.J.setVisibility(4);
        }
        pbCommenFloorItemViewHolder.r.setVisibility(8);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.o.getLayoutParams();
        layoutParams3.topMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
        if (pbCommenFloorItemViewHolder.q.getVisibility() == 8) {
            pbCommenFloorItemViewHolder.o.setVisibility(8);
        } else {
            pbCommenFloorItemViewHolder.o.setVisibility(0);
        }
        pbCommenFloorItemViewHolder.c0.setText(TbadkCoreApplication.getInst().getString(R.string.reply));
    }

    public final void J0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048585, this, pbCommenFloorItemViewHolder, postData, view) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
        }
        layoutParams.rightMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.M_W_X007);
        layoutParams.leftMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
        if (!this.u) {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.m.h0(null);
            pbCommenFloorItemViewHolder.m.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.transparent_bg);
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().x(R.drawable.pic_video);
        u0(pbCommenFloorItemViewHolder.m, view, !StringUtils.isNull(postData.u()));
        pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
        pbCommenFloorItemViewHolder.m.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbCommenFloorItemViewHolder.m.setIsFromCDN(this.q);
        pbCommenFloorItemViewHolder.m.setText(postData.K(), true, this.t);
        SparseArray sparseArray = (SparseArray) pbCommenFloorItemViewHolder.m.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_is_subpb, Boolean.FALSE);
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
        pbCommenFloorItemViewHolder.f19287b.setTag(R.id.tag_from, sparseArray);
        pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.Z.setTag(sparseArray);
    }

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.f19287b == null) {
            return;
        }
        d.a.q0.h2.o.b bVar = this.m;
        if (bVar != null && bVar.y() != null && this.m.y().q1() && StringHelper.equals(this.m.y().o0(), postData.E())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19287b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19287b, R.color.CAM_X0205);
        }
    }

    public final void L0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.O() != null) {
                TbRichText K = postData.K();
                d.a.q0.h2.p.f.c(postData.O(), pbCommenFloorItemViewHolder.K, false, false, K != null && StringUtils.isNull(K.toString()) && StringUtils.isNull(postData.u()));
                return;
            }
            pbCommenFloorItemViewHolder.K.setVisibility(8);
        }
    }

    public final void M0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData.C() != 2 && postData.C() != 4) {
                pbCommenFloorItemViewHolder.R.setVisibility(8);
                pbCommenFloorItemViewHolder.Q.setVisibility(0);
                x0(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.R.setOnClickListener(new d(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                w0(pbCommenFloorItemViewHolder, postData.Y(), postData.B());
                x0(true, pbCommenFloorItemViewHolder, postData);
            }
            U0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void N0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.g(postData.S, postData.E(), this.I);
    }

    /* JADX WARN: Removed duplicated region for block: B:241:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0684  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x06cb  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0736  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x073f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x077e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(1048590, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (postData.t() != null) {
            postData.t().isBaijiahaoUser();
        }
        if (postData.R) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19289d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.f19289d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.f19289d.setVisibility(8);
        }
        b2 b2Var = null;
        pbCommenFloorItemViewHolder.l.setTag(null);
        pbCommenFloorItemViewHolder.l.setUserId(null);
        pbCommenFloorItemViewHolder.f19290e.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.m.setIsHost(false);
        if (postData.t() != null) {
            String str = this.w;
            if (str != null && !"0".equals(str) && this.w.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.m.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.t().getUserId());
                d.a.q0.h2.o.b bVar = this.m;
                if (bVar != null && bVar.z() != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(this.m.z().mEvent.f57758c);
                }
                int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, 2, g2, g2, d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (pbCommenFloorItemViewHolder.G != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                }
                d.a.q0.h2.o.b bVar2 = this.m;
                if (bVar2 != null && bVar2.z() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.m.z().mEvent.f57759d);
                }
                int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g3, g3, d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (d.a.p0.b.d.J()) {
                    if (DeviceInfoUtil.isMate30()) {
                        r0.j(pbCommenFloorItemViewHolder.f19290e);
                    } else {
                        d.a.p0.s.u.c.d(pbCommenFloorItemViewHolder.f19290e).y(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            int i3 = postData.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_user_id, postData.t().getUserId());
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_statistic_item, d.a.q0.h2.m.a.i(this.x, postData, postData.i0, i3, 2));
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f19290e.setText(d.a.q0.h2.c.b(this.f42341e, pbCommenFloorItemViewHolder.f19290e.getText().toString()));
                pbCommenFloorItemViewHolder.f19290e.setGravity(16);
                pbCommenFloorItemViewHolder.f19290e.setTag(R.id.tag_nick_name_activity, d.a.q0.h2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().getImgUrl())) {
                pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds32);
                pbCommenFloorItemViewHolder.F.i(postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setVisibility(8);
                pbCommenFloorItemViewHolder.F.setVisibility(0);
                pbCommenFloorItemViewHolder.F.getHeadView().M(avater, 28, false);
                pbCommenFloorItemViewHolder.F.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.F.getHeadView().setUserName(postData.t().getUserName());
                d.a.q0.h2.h.e eVar = this.x;
                pbCommenFloorItemViewHolder.F.getHeadView().setFid(eVar != null ? eVar.n() : "");
                d.a.q0.h2.h.e eVar2 = this.x;
                pbCommenFloorItemViewHolder.F.getHeadView().setFName(eVar2 != null ? eVar2.o() : "");
                pbCommenFloorItemViewHolder.F.getHeadView().setFloor(postData.A());
                pbCommenFloorItemViewHolder.F.getHeadView().setTid(postData.E());
                pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, d.a.q0.h2.m.a.i(this.x, postData, postData.i0, i3, 2));
                pbCommenFloorItemViewHolder.F.l(postData.t().getPendantData().getImgUrl());
            } else {
                pbCommenFloorItemViewHolder.l.setGodIconWidth(R.dimen.tbds32);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.l, postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setUserId(postData.t().getUserId());
                d.a.q0.h2.h.e eVar3 = this.x;
                pbCommenFloorItemViewHolder.l.setFid(eVar3 != null ? eVar3.n() : "");
                d.a.q0.h2.h.e eVar4 = this.x;
                pbCommenFloorItemViewHolder.l.setFName(eVar4 != null ? eVar4.o() : "");
                pbCommenFloorItemViewHolder.l.setFloor(postData.A());
                pbCommenFloorItemViewHolder.l.setTid(postData.E());
                pbCommenFloorItemViewHolder.l.setUserName(postData.t().getUserName(), postData.T());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_statistic_item, d.a.q0.h2.m.a.i(this.x, postData, postData.i0, i3, 2));
                pbCommenFloorItemViewHolder.l.setImageDrawable(null);
                pbCommenFloorItemViewHolder.l.M(avater, 28, false);
                pbCommenFloorItemViewHolder.l.setVisibility(0);
                pbCommenFloorItemViewHolder.F.setVisibility(8);
            }
            if (postData.t() != null && postData.t().getAlaInfo() != null && postData.t().getAlaUserData() != null && postData.t().getAlaUserData().live_status == 1) {
                pbCommenFloorItemViewHolder.e(true);
                pbCommenFloorItemViewHolder.l.setLiveStatus(1);
                pbCommenFloorItemViewHolder.l.setAlaInfo(postData.t().getAlaInfo());
                pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(1);
                pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(postData.t().getAlaInfo());
            } else {
                pbCommenFloorItemViewHolder.e(false);
                pbCommenFloorItemViewHolder.l.setLiveStatus(0);
                pbCommenFloorItemViewHolder.l.setAlaInfo(null);
                pbCommenFloorItemViewHolder.F.getHeadView().setLiveStatus(0);
                pbCommenFloorItemViewHolder.F.getHeadView().setAlaInfo(null);
            }
            d1(pbCommenFloorItemViewHolder.f19291f, postData);
        }
        d.a.q0.h2.o.b bVar3 = this.m;
        int level_id = (bVar3 == null || bVar3.z() == null || !this.m.z().isSimpleForum() || postData.t() == null) ? 0 : postData.t().getLevel_id();
        d.a.q0.h2.h.e eVar5 = this.x;
        if (eVar5 != null && eVar5.e0()) {
            level_id = 0;
        }
        if (level_id > 0) {
            pbCommenFloorItemViewHolder.E.setVisibility(0);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.E, BitmapHelper.getGradeResourceIdInEnterForum(level_id));
        } else {
            pbCommenFloorItemViewHolder.E.setVisibility(8);
        }
        int i4 = 15;
        if (pbCommenFloorItemViewHolder.H.getChildCount() == 1) {
            i4 = 13;
        } else if (pbCommenFloorItemViewHolder.H.getChildCount() > 1) {
            i4 = 11;
        }
        if (pbCommenFloorItemViewHolder.f19291f.getVisibility() == 0) {
            i4 -= 2;
        }
        if (pbCommenFloorItemViewHolder.G.getChildCount() > 0) {
            i4 -= 2;
        }
        if (postData.w() > 1000) {
            i4 -= 2;
        }
        if (postData.w() > 10) {
            i4 -= 2;
        }
        if (i4 < 10) {
            pbCommenFloorItemViewHolder.H.setVisibility(8);
            if (pbCommenFloorItemViewHolder.H.getChildCount() == 1) {
                i4 += 2;
            } else if (pbCommenFloorItemViewHolder.H.getChildCount() > 1) {
                i4 += 4;
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.f19291f.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.f19291f.setVisibility(8);
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.E.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
        }
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = d.a.p0.b1.j0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i5 = i4 - 2;
            if (d2 > i5) {
                name_show2 = d.a.p0.b1.j0.m(name_show2, i5) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i4) {
            name_show2 = d.a.p0.b1.j0.m(name_show2, i4) + StringHelper.STRING_MORE;
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f19290e.setText(Q0(postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f19290e.setText(name_show2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_clip_board, postData);
        sparseArray.put(R.id.tag_load_sub_data, postData);
        sparseArray.put(R.id.tag_load_sub_view, view);
        sparseArray.put(R.id.tag_pb_floor_postion, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_pb_floor_number, Integer.valueOf(postData.A()));
        sparseArray.put(R.id.tag_forbid_user_post_id, postData.E());
        sparseArray.put(R.id.pb_dialog_item_zan_1, pbCommenFloorItemViewHolder.k);
        sparseArray.put(R.id.pb_dialog_item_zan_2, pbCommenFloorItemViewHolder.Y);
        sparseArray.put(R.id.pb_dialog_item_reply, pbCommenFloorItemViewHolder.s);
        sparseArray.put(R.id.pb_dialog_item_share, pbCommenFloorItemViewHolder.t);
        d.a.q0.h2.h.e eVar6 = this.x;
        if (eVar6 != null && eVar6.N() != null) {
            b2Var = this.x.N();
        }
        if (b2Var != null && b2Var.r2()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z6 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        d.a.q0.h2.h.e eVar7 = this.x;
        if (eVar7 == null || eVar7.U() == 0) {
            z = false;
            z2 = false;
        } else {
            z = (this.x.U() == 1002 || this.x.U() == 3) ? false : true;
            z2 = (this.x.U() == 3 || this.x.e0()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || "0".equals(userId) || userId.length() == 0) {
                    z = false;
                }
            }
        }
        d.a.q0.h2.h.e eVar8 = this.x;
        if (eVar8 != null && eVar8.N() != null && this.x.N().H() != null && postData.t() != null) {
            String userId2 = this.x.N().H().getUserId();
            String userId3 = postData.t().getUserId();
            if (UtilHelper.isCurrentAccount(userId2)) {
                if (UtilHelper.isCurrentAccount(userId3)) {
                    z4 = false;
                    z5 = true;
                } else {
                    z4 = true;
                    z5 = false;
                }
                z3 = true;
                if (postData != null && postData.t() != null && UtilHelper.isCurrentAccount(postData.t().getUserId())) {
                    z5 = true;
                    z3 = true;
                }
                if (z6) {
                    z = false;
                    z4 = false;
                    z3 = false;
                }
                int i6 = postData.A() != 1 ? 1 : 0;
                if (!z) {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.x.U()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_forbid_user_name, postData.t().getUserName());
                        sparseArray.put(R.id.tag_forbid_user_name_show, postData.t().getName_show());
                        sparseArray.put(R.id.tag_forbid_user_portrait, postData.t().getPortrait());
                    }
                } else {
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                }
                if (!z4) {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.t() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.t().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.t().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.t().getName_show());
                    }
                    if (this.x.N() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.x.N().d0());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.x.U()));
                    sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i6));
                    sparseArray.put(R.id.tag_del_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                }
                pbCommenFloorItemViewHolder.m.setTag(sparseArray);
            }
        }
        z3 = z2;
        z4 = false;
        z5 = false;
        if (postData != null) {
            z5 = true;
            z3 = true;
        }
        if (z6) {
        }
        if (postData.A() != 1) {
        }
        if (!z) {
        }
        if (!z4) {
        }
        if (!z3) {
        }
        pbCommenFloorItemViewHolder.m.setTag(sparseArray);
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E : invokeV.intValue;
    }

    public final SpannableStringBuilder Q0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return d.a.q0.a0.m.h(this.m.z(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String R0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, view)) == null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            if (sparseArray == null) {
                return "1";
            }
            Object obj = sparseArray.get(R.id.pb_track_more_obj_source);
            String str = obj != null ? obj : "1";
            sparseArray.remove(R.id.pb_track_more_obj_source);
            view.setTag(sparseArray);
            return str.toString();
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.d.k.e.a
    /* renamed from: S0 */
    public PbCommenFloorItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f42341e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.z().getPageContext(), inflate, this.G);
            pbCommenFloorItemViewHolder.n.setConstrainLayoutPool(this.J);
            pbCommenFloorItemViewHolder.n.setImageViewPool(this.K);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.H);
            }
            b1(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.m;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.F);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View T0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.X(i2, view, viewGroup, postData, pbCommenFloorItemViewHolder);
            b1(pbCommenFloorItemViewHolder);
            X0(pbCommenFloorItemViewHolder);
            p0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.i0 = i2 + 1;
                t0(postData2);
                r0(postData2);
                postData2.B0();
                A0(postData2);
                F0(pbCommenFloorItemViewHolder, postData2, view, i2);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void U0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText K = postData.K();
            K.isChanged = true;
            pbCommenFloorItemViewHolder.m.setText(K, true, this.t);
        }
    }

    public final void V0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, postData) == null) {
            String userId = postData.t().getUserId();
            d.a.q0.h2.h.e eVar = this.x;
            String n = eVar != null ? eVar.n() : "";
            d.a.q0.h2.h.e eVar2 = this.x;
            String o = eVar2 != null ? eVar2.o() : "";
            int A = postData.A();
            String E = postData.E();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", n);
            statisticItem.param("fname", o);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", E);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, A);
            if (postData.t().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.t().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public void W0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.E = i2;
        }
    }

    @Override // d.a.q0.h2.k.e.o, d.a.d.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        T0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public final void X0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.f19287b.setOnTouchListener(this.L);
            pbCommenFloorItemViewHolder.f19287b.setOnLongClickListener(this.C);
            if (this.m.z() == null || this.m.z().getPageContext() == null || this.m.z().getPageContext().getOrignalPage() == null) {
                return;
            }
            d.a.q0.h2.k.e.d1.a aVar = this.m.z().mEvent;
            pbCommenFloorItemViewHolder.f19290e.setOnClickListener(aVar.f57757b);
            pbCommenFloorItemViewHolder.l.setOnClickListener(aVar.f57757b);
            pbCommenFloorItemViewHolder.F.setOnClickListener(aVar.f57757b);
            pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(aVar.f57757b);
            pbCommenFloorItemViewHolder.m.setOnLongClickListener(this.C);
            pbCommenFloorItemViewHolder.m.setOnTouchListener(this.L);
            pbCommenFloorItemViewHolder.m.setCommonTextViewOnClickListener(this.z);
            pbCommenFloorItemViewHolder.m.setOnImageClickListener(this.A);
            pbCommenFloorItemViewHolder.m.setOnImageTouchListener(this.L);
            pbCommenFloorItemViewHolder.m.setOnEmotionClickListener(aVar.f57760e);
            pbCommenFloorItemViewHolder.m.setOnVoiceAfterClickListener(this.z);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.q.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.r.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.Z.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.d0.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.a0.setOnClickListener(new e(this, pbCommenFloorItemViewHolder));
            d.a.q0.h2.k.e.d1.c cVar = this.m.z().mPostShareController;
            pbCommenFloorItemViewHolder.s.setOnClickListener(this.z);
            pbCommenFloorItemViewHolder.t.setOnClickListener(new f(this, pbCommenFloorItemViewHolder, cVar));
            pbCommenFloorItemViewHolder.k.z = new g(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.Y.z = new h(this, pbCommenFloorItemViewHolder);
        }
    }

    public void Y0(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            this.v = f2;
        }
    }

    public void Z0(d.a.q0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cVar) == null) {
            this.B = cVar;
        }
    }

    public void a1(TbRichTextView.t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, tVar) == null) {
            this.t = tVar;
        }
    }

    public final void b1(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.f19286a != skinType) {
            c1(pbCommenFloorItemViewHolder.f19291f);
            if (d.a.p0.b.d.J()) {
                if (DeviceInfoUtil.isMate30()) {
                    r0.j(pbCommenFloorItemViewHolder.f19290e);
                } else {
                    d.a.p0.s.u.c.d(pbCommenFloorItemViewHolder.f19290e).y(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19290e, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19292g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19293h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19294i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.b0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.c0, R.color.CAM_X0107, 1);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
            int i2 = R.color.CAM_X0206;
            SkinManager.setBackgroundShapeDrawable(subPbLayout, g2, i2, i2);
            SkinManager.getColor(R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.q, R.color.CAM_X0107);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.q, R.color.CAM_X0304);
            pbCommenFloorItemViewHolder.q.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, WebPManager.getPureDrawable(R.drawable.icon_pure_arrow12_right, SkinManager.getColor(R.color.CAM_X0304), null), (Drawable) null);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.s, R.drawable.icon_pure_pb_reply18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.t, R.drawable.icon_pure_pb_share18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.p.d();
            pbCommenFloorItemViewHolder.n.b();
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.O, R.color.CAM_X0304, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.M, R.color.CAM_X0106, 1);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.L, R.color.CAM_X0205);
            SkinManager.setBackgroundResource(pbCommenFloorItemViewHolder.N, R.color.CAM_X0109);
            SkinManager.setImageResource(pbCommenFloorItemViewHolder.P, R.drawable.icon_arrow_more_gray);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.S, R.color.CAM_X0107);
            if (pbCommenFloorItemViewHolder.Q.getVisibility() == 8) {
                pbCommenFloorItemViewHolder.S.setText(R.string.close_content);
            } else {
                d.a.q0.h2.h.e eVar = this.x;
                if (eVar != null && StringUtils.isNull(eVar.l())) {
                    pbCommenFloorItemViewHolder.S.setText(this.x.l());
                } else {
                    pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                }
            }
            pbCommenFloorItemViewHolder.k.v(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.Z, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.f19286a = skinType;
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.u = z;
        }
    }

    public final void c1(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            d1(textView, (PostData) tag);
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onLongClickListener) == null) {
            this.C = onLongClickListener;
        }
    }

    public final void d1(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            d.a.q0.h2.h.e eVar = this.x;
            if (eVar != null && eVar.e0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.w;
                if (str != null && !"0".equals(str) && this.w.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    d.a.p0.s.u.c d2 = d.a.p0.s.u.c.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.t(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.X()) {
                    d.a.p0.s.u.c d3 = d.a.p0.s.u.c.d(textView);
                    d3.t(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    d.a.p0.s.u.c d4 = d.a.p0.s.u.c.d(textView);
                    d4.t(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    d.a.p0.s.u.c d5 = d.a.p0.s.u.c.d(textView);
                    d5.t(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    d.a.p0.s.u.c d6 = d.a.p0.s.u.c.d(textView);
                    d6.t(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    d.a.p0.s.u.c d7 = d.a.p0.s.u.c.d(textView);
                    d7.t(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.z = onClickListener;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, view) == null) {
        }
    }

    public void p(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, zVar) == null) {
            this.A = zVar;
        }
    }

    public final void p0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.B);
            pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.w = str;
        }
    }

    public final void r0(PostData postData) {
        d.a.q0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, postData) == null) || (eVar = this.x) == null) {
            return;
        }
        if (eVar.l0()) {
            AbsVideoPbFragment absVideoPbFragment = this.o;
            if (absVideoPbFragment != null) {
                d.a.q0.h2.m.a.e(absVideoPbFragment.getUniqueId(), this.x, postData, postData.i0, postData.c0 ? 2 : 8, "common_exp_source_pb_comment");
                return;
            }
            return;
        }
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            d.a.q0.h2.m.a.e(pbFragment.getUniqueId(), this.x, postData, postData.i0, postData.c0 ? 2 : 8, "common_exp_source_pb_comment");
        }
    }

    public void t(d.a.q0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, eVar) == null) {
            this.x = eVar;
        }
    }

    public final void t0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048618, this, postData) == null) && postData.E == 0 && postData.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.E());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            d.a.q0.h2.o.b bVar = this.m;
            if (bVar != null) {
                int K0 = bVar.y().K0();
                if (1 == K0 || 2 == K0) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == K0) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.t() == null || postData.t().getAlaInfo() == null || postData.t().getAlaInfo().live_status != 1) {
                return;
            }
            V0(postData);
        }
    }

    public final void u0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048619, this, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k = (((d.a.d.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int e0 = z ? e0(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q((int) ((k - e0) * this.v));
        tbRichTextView.getLayoutStrategy().D = (k - e0) - e0(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f * this.v));
    }

    public final void w0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
            if (z) {
                pbCommenFloorItemViewHolder.Q.setVisibility(8);
                if (StringUtils.isNull(str)) {
                    pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                    return;
                } else {
                    pbCommenFloorItemViewHolder.S.setText(str);
                    return;
                }
            }
            pbCommenFloorItemViewHolder.Q.setVisibility(0);
            pbCommenFloorItemViewHolder.S.setText(R.string.close_content);
        }
    }

    public final void x0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.J) == null || pbCommenFloorItemViewHolder.R == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.R.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.M());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.R.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.R.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().m(d.a.d.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = d.a.d.e.p.l.g(this.f42341e, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
        }
    }

    public final void z0(View view) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, view) == null) || view == null || !(view.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag()).Y) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.Y.u();
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
        statisticItem.param("fid", this.x.n());
        statisticItem.param("tid", this.x.P());
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("post_id", this.x.j().E());
        statisticItem.param("obj_source", 1);
        statisticItem.param("obj_type", 1);
        statisticItem.param("obj_locate", P0());
        TiebaStatic.log(statisticItem);
    }
}
