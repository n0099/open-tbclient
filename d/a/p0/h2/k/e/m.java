package d.a.p0.h2.k.e;

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
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
import d.a.p0.a0.m;
import d.a.p0.h2.i.c;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class m extends o<PostData, PbCommenFloorItemViewHolder> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.p0.h2.i.c A;
    public View.OnLongClickListener B;
    public d.a.p0.h2.k.g.b C;
    public boolean D;
    public int E;
    public boolean F;
    public boolean G;
    public d.a.c.e.k.b<ConstrainImageLayout> H;
    public d.a.c.e.k.b<TbImageView> I;
    public d.a.p0.h2.i.c J;
    public int s;
    public TbRichTextView.r t;
    public boolean u;
    public String v;
    public d.a.p0.h2.h.e w;
    public View.OnClickListener x;
    public View.OnClickListener y;
    public TbRichTextView.x z;

    /* loaded from: classes8.dex */
    public class a implements d.a.c.e.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f57353a;

        public a(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57353a = mVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f57353a.f41837e) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.a.c.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ m f57354a;

        public b(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57354a = mVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // d.a.c.e.k.c
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
        @Override // d.a.c.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f57354a.f41837e);
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
        public final /* synthetic */ m f57355a;

        public c(m mVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57355a = mVar;
        }

        @Override // d.a.p0.h2.i.c.a
        public boolean a(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                return false;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.p0.h2.i.c.a
        public boolean b(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, motionEvent)) == null) {
                if (this.f57355a.A != null) {
                    if (!(view instanceof TbListTextView) || this.f57355a.y == null) {
                        this.f57355a.A.a(view);
                        this.f57355a.A.onSingleTapConfirmed(motionEvent);
                        return true;
                    }
                    this.f57355a.y.onClick(view);
                    return true;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // d.a.p0.h2.i.c.a
        public boolean c(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            PbFragment pbFragment;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, motionEvent)) == null) {
                if (view == null || !((pbFragment = this.f57355a.n) == null || pbFragment.Q4() == null || this.f57355a.n.Q4().p1())) {
                    return true;
                }
                if (view instanceof RelativeLayout) {
                    this.f57355a.z0(view);
                } else {
                    ViewParent parent = view.getParent();
                    int i2 = 0;
                    while (true) {
                        if (parent == null || i2 >= 10) {
                            break;
                        } else if (parent instanceof RelativeLayout) {
                            this.f57355a.z0((RelativeLayout) parent);
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
        public final /* synthetic */ PbCommenFloorItemViewHolder f57356e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PostData f57357f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f57358g;

        public d(m mVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, pbCommenFloorItemViewHolder, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57358g = mVar;
            this.f57356e = pbCommenFloorItemViewHolder;
            this.f57357f = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                boolean z = this.f57356e.Q.getVisibility() == 8;
                this.f57358g.x0(this.f57356e, !z, this.f57357f.B());
                this.f57357f.m0(!z);
                this.f57358g.T0(this.f57356e, this.f57357f);
                PbFragment pbFragment = this.f57358g.n;
                if (pbFragment == null || pbFragment.Q4() == null || this.f57358g.n.Q4().U0() == null || this.f57358g.n.Q4().B0() == null || z || this.f57356e.a().getTop() >= this.f57358g.n.Q4().U0().getMeasuredHeight()) {
                    return;
                }
                this.f57358g.n.Q4().B0().setSelectionFromTop(ListUtils.getPosition(this.f57358g.n.Q4().B0().getData(), this.f57357f) + this.f57358g.n.Q4().B0().getHeaderViewsCount(), this.f57358g.n.Q4().U0().getMeasuredHeight());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f57359e;

        public e(m mVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57359e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57359e.s.performClick();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f57360e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.h2.k.e.c1.c f57361f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ m f57362g;

        /* loaded from: classes8.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f57363e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f57364f;

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
                this.f57364f = fVar;
                this.f57363e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.f57364f;
                    fVar.f57361f.f57194b.a(fVar.f57362g.w, null, this.f57363e, fVar.f57360e.m.getLayoutStrategy());
                }
            }
        }

        public f(m mVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, d.a.p0.h2.k.e.c1.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, pbCommenFloorItemViewHolder, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57362g = mVar;
            this.f57360e = pbCommenFloorItemViewHolder;
            this.f57361f = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f57360e.f19202b == null || this.f57361f == null) {
                    return;
                }
                d.a.c.e.m.e.a().postDelayed(new a(this, postData), 100L);
                String P = this.f57362g.w.P();
                if ((StringUtils.isNull(P) || "0".equals(this.f57362g.w.P())) && this.f57362g.w.N() != null) {
                    P = this.f57362g.w.N().A0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.f57362g.w.n()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", this.f57362g.Q0(view)).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f57365e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f57366f;

        public g(m mVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57366f = mVar;
            this.f57365e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f57366f.w == null || (pbCommenFloorItemViewHolder = this.f57365e) == null || (agreeView = pbCommenFloorItemViewHolder.k) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f57365e.k.getImgAgree() ? 1 : 2;
            String P = this.f57366f.w.P();
            if ((StringUtils.isNull(P) || "0".equals(this.f57366f.w.P())) && this.f57366f.w.N() != null) {
                P = this.f57366f.w.N().A0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.f57366f.w.n()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f57365e.k.getData().postId).param("obj_source", this.f57366f.Q0(this.f57365e.k)).param("obj_type", i2));
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f57367e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ m f57368f;

        public h(m mVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f57368f = mVar;
            this.f57367e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f57368f.w == null || (pbCommenFloorItemViewHolder = this.f57367e) == null || (agreeView = pbCommenFloorItemViewHolder.Y) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f57367e.Y.getImgAgree() ? 1 : 2;
            String P = this.f57368f.w.P();
            if ((StringUtils.isNull(P) || "0".equals(this.f57368f.w.P())) && this.f57368f.w.N() != null) {
                P = this.f57368f.w.N().A0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", P).param("fid", this.f57368f.w.n()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f57367e.Y.getData().postId).param("obj_source", this.f57368f.Q0(this.f57367e.Y)).param("obj_type", i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(d.a.p0.h2.o.b bVar, BdUniqueId bdUniqueId) {
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
                super((d.a.p0.h2.o.b) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 0;
        this.t = null;
        this.u = true;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = true;
        this.F = true;
        this.G = false;
        this.H = new d.a.c.e.k.b<>(new a(this), 6, 0);
        this.I = new d.a.c.e.k.b<>(new b(this), 12, 0);
        this.J = new d.a.p0.h2.i.c(new c(this));
        if (bVar != null && bVar.y() != null) {
            this.E = bVar.y().C0();
        }
        this.s = f0(R.dimen.tbds14);
    }

    public final void A0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, postData) == null) || postData == null) {
            return;
        }
        StatisticItem i2 = d.a.p0.h2.m.a.i(this.w, postData, postData.i0, postData.c0 ? 2 : 8, 6);
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
                layoutParams.topMargin = f0(R.dimen.ds20);
                layoutParams.bottomMargin = f0(R.dimen.ds20);
                pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams);
                pbCommenFloorItemViewHolder.m.e0(postData.u());
            } else {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbCommenFloorItemViewHolder.m.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                pbCommenFloorItemViewHolder.m.setLayoutParams(layoutParams2);
                pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
                pbCommenFloorItemViewHolder.m.e0(null);
            }
            pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.J);
            pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
        }
    }

    public final void C0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        ImageView imageView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null || (imageView = pbCommenFloorItemViewHolder.I) == null || this.w == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public final void D0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        boolean z;
        int i2;
        int i3;
        d.a.p0.h2.h.e eVar;
        d.a.p0.h2.h.e eVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        boolean z2 = true;
        if (postData.A() > 0 && (eVar2 = this.w) != null && !eVar2.e0()) {
            String format = String.format(this.f41837e.getString(R.string.is_floor), Integer.valueOf(postData.A()));
            pbCommenFloorItemViewHolder.D.setVisibility(0);
            pbCommenFloorItemViewHolder.D.setText(format);
            z = true;
        } else {
            pbCommenFloorItemViewHolder.D.setVisibility(8);
            z = false;
        }
        d.a.o0.t.g I = postData.I();
        z2 = (I == null || StringUtils.isNull(I.b()) || (eVar = this.w) == null || eVar.e0()) ? false : false;
        if (z) {
            pbCommenFloorItemViewHolder.f19208h.setVisibility(0);
            i2 = this.s;
        } else {
            pbCommenFloorItemViewHolder.f19208h.setVisibility(8);
            i2 = 0;
        }
        if (z2) {
            pbCommenFloorItemViewHolder.f19209i.setVisibility(0);
            i3 = this.s;
        } else {
            pbCommenFloorItemViewHolder.f19209i.setVisibility(8);
            i3 = 0;
        }
        pbCommenFloorItemViewHolder.f19207g.setPadding(i2, 0, i3, 0);
        if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.R()), "yyyy"))) {
            pbCommenFloorItemViewHolder.f19207g.setText(StringHelper.getFormatTimeShort(postData.R()));
        } else {
            pbCommenFloorItemViewHolder.f19207g.setText(StringHelper.getFormatTime(postData.R()));
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
        textView.setText(((Object) pbCommenFloorItemViewHolder.f19207g.getText()) + "  • ");
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
        postData.q().threadId = this.m.y().T0();
        postData.q().objType = 1;
        postData.q().isInPost = true;
        b2 b2Var = null;
        d.a.p0.h2.h.e eVar = this.w;
        if (eVar != null && eVar.N() != null) {
            b2Var = this.w.N();
        }
        if (b2Var != null && b2Var.p2()) {
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
            layoutParams.topMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds10);
            layoutParams.leftMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds148);
            layoutParams.rightMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.M_W_X007);
            layoutParams.bottomMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds20);
            pbCommenFloorItemViewHolder.p.setLayoutParams(layoutParams);
            if (this.C == null) {
                d.a.p0.h2.k.g.b bVar = new d.a.p0.h2.k.g.b(this.f41837e);
                this.C = bVar;
                bVar.f(this.q);
                this.C.h(this.x);
                this.C.e(this.y);
                String str = null;
                d.a.p0.h2.h.e eVar = this.w;
                if (eVar != null && eVar.N() != null && this.w.N().H() != null) {
                    str = this.w.N().H().getUserId();
                }
                boolean z = true;
                z = (str == null || !str.equals(TbadkCoreApplication.getCurrentAccount())) ? false : false;
                d.a.p0.h2.h.e eVar2 = this.w;
                if (eVar2 != null) {
                    this.C.j(eVar2.U(), z);
                    this.C.i(this.w.N());
                }
            }
            this.C.g(postData.E());
            pbCommenFloorItemViewHolder.p.setSubPbAdapter(this.C);
            pbCommenFloorItemViewHolder.p.setVisibility(0);
            pbCommenFloorItemViewHolder.p.setData(postData, view);
            pbCommenFloorItemViewHolder.p.setChildOnClickListener(this.y);
            pbCommenFloorItemViewHolder.p.setChildOnLongClickListener(this.B);
            pbCommenFloorItemViewHolder.p.setChildOnTouchListener(this.J);
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
        layoutParams3.topMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X001);
        layoutParams3.bottomMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X002);
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
        layoutParams.rightMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.M_W_X007);
        layoutParams.leftMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds148);
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = 0;
        pbCommenFloorItemViewHolder.m.setPadding(0, 0, 0, 0);
        if (!this.u) {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.icon_click);
        } else {
            pbCommenFloorItemViewHolder.m.e0(null);
            pbCommenFloorItemViewHolder.m.setBackgroundDrawable(null);
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().g(R.drawable.transparent_bg);
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().x(R.drawable.pic_video);
        w0(pbCommenFloorItemViewHolder.m, view, !StringUtils.isNull(postData.u()));
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
        pbCommenFloorItemViewHolder.f19202b.setTag(R.id.tag_from, sparseArray);
        pbCommenFloorItemViewHolder.d0.setTag(sparseArray);
        pbCommenFloorItemViewHolder.Z.setTag(sparseArray);
    }

    public final void K0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.f19202b == null) {
            return;
        }
        d.a.p0.h2.o.b bVar = this.m;
        if (bVar != null && bVar.y() != null && this.m.y().h1() && StringHelper.equals(this.m.y().g0(), postData.E())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19202b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19202b, R.color.CAM_X0205);
        }
    }

    public final void L0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, pbCommenFloorItemViewHolder, postData) == null) {
            if (postData != null && postData.O() != null) {
                TbRichText K = postData.K();
                d.a.p0.h2.p.f.c(postData.O(), pbCommenFloorItemViewHolder.K, false, false, K != null && StringUtils.isNull(K.toString()) && StringUtils.isNull(postData.u()));
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
                y0(false, pbCommenFloorItemViewHolder, postData);
            } else {
                pbCommenFloorItemViewHolder.R.setOnClickListener(new d(this, pbCommenFloorItemViewHolder, postData));
                pbCommenFloorItemViewHolder.R.setVisibility(0);
                x0(pbCommenFloorItemViewHolder, postData.Y(), postData.B());
                y0(true, pbCommenFloorItemViewHolder, postData);
            }
            T0(pbCommenFloorItemViewHolder, postData);
        }
    }

    public final void N0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.g(postData.S, postData.E(), this.G);
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
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19204d, R.color.CAM_X0204);
            pbCommenFloorItemViewHolder.f19204d.setVisibility(0);
        } else {
            pbCommenFloorItemViewHolder.f19204d.setVisibility(8);
        }
        b2 b2Var = null;
        pbCommenFloorItemViewHolder.l.setTag(null);
        pbCommenFloorItemViewHolder.l.setUserId(null);
        pbCommenFloorItemViewHolder.f19205e.setText((CharSequence) null);
        pbCommenFloorItemViewHolder.F.getHeadView().setUserId(null);
        pbCommenFloorItemViewHolder.m.setIsHost(false);
        if (postData.t() != null) {
            String str = this.v;
            if (str != null && !str.equals("0") && this.v.equals(postData.t().getUserId())) {
                pbCommenFloorItemViewHolder.m.setIsHost(true);
            }
            ArrayList<IconData> iconInfo = postData.t().getIconInfo();
            ArrayList<IconData> tShowInfoNew = postData.t().getTShowInfoNew();
            UserIconBox userIconBox = pbCommenFloorItemViewHolder.H;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, postData.t().getUserId());
                d.a.p0.h2.o.b bVar = this.m;
                if (bVar != null && bVar.z() != null) {
                    pbCommenFloorItemViewHolder.H.setOnClickListener(this.m.z().mEvent.f57171c);
                }
                int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                pbCommenFloorItemViewHolder.H.g(iconInfo, 2, g2, g2, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            }
            if (pbCommenFloorItemViewHolder.G != null) {
                if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                    pbCommenFloorItemViewHolder.G.setTag(tShowInfoNew.get(0).getUrl());
                }
                d.a.p0.h2.o.b bVar2 = this.m;
                if (bVar2 != null && bVar2.z() != null) {
                    pbCommenFloorItemViewHolder.G.setOnClickListener(this.m.z().mEvent.f57172d);
                }
                int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                pbCommenFloorItemViewHolder.G.h(tShowInfoNew, 3, g3, g3, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
            }
            if (ListUtils.isEmpty(tShowInfoNew) && !postData.t().isBigV()) {
                if (d.a.o0.b.d.H()) {
                    if (DeviceInfoUtil.isMate30()) {
                        r0.j(pbCommenFloorItemViewHolder.f19205e);
                    } else {
                        d.a.o0.r.u.c.d(pbCommenFloorItemViewHolder.f19205e).y(R.string.F_X02);
                    }
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19205e, R.color.CAM_X0108, 1);
                } else {
                    SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19205e, R.color.CAM_X0107, 1);
                }
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19205e, R.color.CAM_X0301, 1);
            }
            String avater = postData.t().getAvater();
            int i3 = postData.c0 ? 2 : 8;
            pbCommenFloorItemViewHolder.f19205e.setTag(R.id.tag_user_id, postData.t().getUserId());
            pbCommenFloorItemViewHolder.f19205e.setTag(R.id.tag_user_name, postData.t().getUserName());
            pbCommenFloorItemViewHolder.f19205e.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
            pbCommenFloorItemViewHolder.f19205e.setTag(R.id.tag_statistic_item, d.a.p0.h2.m.a.i(this.w, postData, postData.i0, i3, 2));
            String name_show = postData.t().getName_show();
            String userName = postData.t().getUserName();
            if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                pbCommenFloorItemViewHolder.f19205e.setText(d.a.p0.h2.c.b(this.f41837e, pbCommenFloorItemViewHolder.f19205e.getText().toString()));
                pbCommenFloorItemViewHolder.f19205e.setGravity(16);
                pbCommenFloorItemViewHolder.f19205e.setTag(R.id.tag_nick_name_activity, d.a.p0.h2.c.a());
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19205e, R.color.CAM_X0312, 1);
            }
            if (postData.t().getPendantData() != null && !StringUtils.isNull(postData.t().getPendantData().a())) {
                pbCommenFloorItemViewHolder.F.setBigVDimenSize(R.dimen.tbds32);
                pbCommenFloorItemViewHolder.F.i(postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setVisibility(8);
                pbCommenFloorItemViewHolder.F.setVisibility(0);
                pbCommenFloorItemViewHolder.F.getHeadView().M(avater, 28, false);
                pbCommenFloorItemViewHolder.F.getHeadView().setUserId(postData.t().getUserId());
                pbCommenFloorItemViewHolder.F.getHeadView().setUserName(postData.t().getUserName());
                d.a.p0.h2.h.e eVar = this.w;
                pbCommenFloorItemViewHolder.F.getHeadView().setFid(eVar != null ? eVar.n() : "");
                d.a.p0.h2.h.e eVar2 = this.w;
                pbCommenFloorItemViewHolder.F.getHeadView().setFName(eVar2 != null ? eVar2.o() : "");
                pbCommenFloorItemViewHolder.F.getHeadView().setFloor(postData.A());
                pbCommenFloorItemViewHolder.F.getHeadView().setTid(postData.E());
                pbCommenFloorItemViewHolder.F.getHeadView().setTag(R.id.tag_statistic_item, d.a.p0.h2.m.a.i(this.w, postData, postData.i0, i3, 2));
                pbCommenFloorItemViewHolder.F.l(postData.t().getPendantData().a());
            } else {
                pbCommenFloorItemViewHolder.l.setGodIconWidth(R.dimen.tbds32);
                UtilHelper.showHeadImageViewBigV(pbCommenFloorItemViewHolder.l, postData.t(), 4);
                pbCommenFloorItemViewHolder.l.setUserId(postData.t().getUserId());
                d.a.p0.h2.h.e eVar3 = this.w;
                pbCommenFloorItemViewHolder.l.setFid(eVar3 != null ? eVar3.n() : "");
                d.a.p0.h2.h.e eVar4 = this.w;
                pbCommenFloorItemViewHolder.l.setFName(eVar4 != null ? eVar4.o() : "");
                pbCommenFloorItemViewHolder.l.setFloor(postData.A());
                pbCommenFloorItemViewHolder.l.setTid(postData.E());
                pbCommenFloorItemViewHolder.l.setUserName(postData.t().getUserName(), postData.T());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_virtual_user_url, postData.t().getVirtualUserUrl());
                pbCommenFloorItemViewHolder.l.setTag(R.id.tag_statistic_item, d.a.p0.h2.m.a.i(this.w, postData, postData.i0, i3, 2));
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
            c1(pbCommenFloorItemViewHolder.f19206f, postData);
        }
        d.a.p0.h2.o.b bVar3 = this.m;
        int level_id = (bVar3 == null || bVar3.z() == null || !this.m.z().isSimpleForum() || postData.t() == null) ? 0 : postData.t().getLevel_id();
        d.a.p0.h2.h.e eVar5 = this.w;
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
        if (pbCommenFloorItemViewHolder.f19206f.getVisibility() == 0) {
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
            if (i4 < 10 && pbCommenFloorItemViewHolder.f19206f.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.f19206f.setVisibility(8);
            }
            if (i4 < 10 && pbCommenFloorItemViewHolder.E.getVisibility() == 0) {
                i4 += 2;
                pbCommenFloorItemViewHolder.E.setVisibility(8);
            }
        }
        String name_show2 = postData.t() != null ? postData.t().getName_show() : "";
        int d2 = d.a.o0.z0.j0.d(name_show2);
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            int i5 = i4 - 2;
            if (d2 > i5) {
                name_show2 = d.a.o0.z0.j0.m(name_show2, i5) + StringHelper.STRING_MORE;
            }
        } else if (d2 > i4) {
            name_show2 = d.a.o0.z0.j0.m(name_show2, i4) + StringHelper.STRING_MORE;
        }
        if (postData.t() != null && !StringUtils.isNull(postData.t().getSealPrefix())) {
            pbCommenFloorItemViewHolder.f19205e.setText(P0(postData.t().getSealPrefix(), name_show2));
        } else {
            pbCommenFloorItemViewHolder.f19205e.setText(name_show2);
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
        d.a.p0.h2.h.e eVar6 = this.w;
        if (eVar6 != null && eVar6.N() != null) {
            b2Var = this.w.N();
        }
        if (b2Var != null && b2Var.p2()) {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.TRUE);
        } else {
            sparseArray.put(R.id.pb_dialog_item_isugc, Boolean.FALSE);
        }
        boolean z6 = (postData.t() == null || StringUtils.isNull(postData.t().getVirtualUserUrl())) ? false : true;
        d.a.p0.h2.h.e eVar7 = this.w;
        if (eVar7 == null || eVar7.U() == 0) {
            z = false;
            z2 = false;
        } else {
            z = (this.w.U() == 1002 || this.w.U() == 3) ? false : true;
            z2 = (this.w.U() == 3 || this.w.e0()) ? false : true;
            if (postData != null && postData.t() != null) {
                String userId = postData.t().getUserId();
                if (UtilHelper.isCurrentAccount(userId)) {
                    z = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z = false;
                }
            }
        }
        d.a.p0.h2.h.e eVar8 = this.w;
        if (eVar8 != null && eVar8.N() != null && this.w.N().H() != null && postData.t() != null) {
            String userId2 = this.w.N().H().getUserId();
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
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.w.U()));
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
                    if (this.w.N() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.w.N().c0());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.E());
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                }
                if (!z3) {
                    sparseArray.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    sparseArray.put(R.id.tag_has_sub_post, Boolean.valueOf(postData.W()));
                    sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.w.U()));
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

    public final SpannableStringBuilder P0(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return d.a.p0.a0.m.h(this.m.z(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final String Q0(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, view)) == null) {
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
    @Override // d.a.c.k.e.a
    /* renamed from: R0 */
    public PbCommenFloorItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f41837e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.z().getPageContext(), inflate, this.E);
            pbCommenFloorItemViewHolder.n.setConstrainLayoutPool(this.H);
            pbCommenFloorItemViewHolder.n.setImageViewPool(this.I);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
            if (subPbLayout != null) {
                subPbLayout.setShowChildComment(this.F);
            }
            a1(pbCommenFloorItemViewHolder);
            TbRichTextView tbRichTextView = pbCommenFloorItemViewHolder.m;
            if (tbRichTextView != null) {
                tbRichTextView.setDuiEnabled(this.D);
            }
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View S0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            super.X(i2, view, viewGroup, postData, pbCommenFloorItemViewHolder);
            a1(pbCommenFloorItemViewHolder);
            W0(pbCommenFloorItemViewHolder);
            s0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.i0 = i2 + 1;
                v0(postData2);
                t0(postData2);
                postData2.B0();
                A0(postData2);
                F0(pbCommenFloorItemViewHolder, postData2, view, i2);
            }
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void T0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, pbCommenFloorItemViewHolder, postData) == null) {
            TbRichText K = postData.K();
            K.isChanged = true;
            pbCommenFloorItemViewHolder.m.setText(K, true, this.t);
        }
    }

    public final void U0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, postData) == null) {
            String userId = postData.t().getUserId();
            d.a.p0.h2.h.e eVar = this.w;
            String n = eVar != null ? eVar.n() : "";
            d.a.p0.h2.h.e eVar2 = this.w;
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

    public void V0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.D = z;
        }
    }

    public final void W0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.f19202b.setOnTouchListener(this.J);
            pbCommenFloorItemViewHolder.f19202b.setOnLongClickListener(this.B);
            if (this.m.z() == null || this.m.z().getPageContext() == null || this.m.z().getPageContext().getOrignalPage() == null) {
                return;
            }
            d.a.p0.h2.k.e.c1.a aVar = this.m.z().mEvent;
            pbCommenFloorItemViewHolder.f19205e.setOnClickListener(aVar.f57170b);
            pbCommenFloorItemViewHolder.l.setOnClickListener(aVar.f57170b);
            pbCommenFloorItemViewHolder.F.setOnClickListener(aVar.f57170b);
            pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(aVar.f57170b);
            pbCommenFloorItemViewHolder.m.setOnLongClickListener(this.B);
            pbCommenFloorItemViewHolder.m.setOnTouchListener(this.J);
            pbCommenFloorItemViewHolder.m.setCommonTextViewOnClickListener(this.y);
            pbCommenFloorItemViewHolder.m.setOnImageClickListener(this.z);
            pbCommenFloorItemViewHolder.m.setOnImageTouchListener(this.J);
            pbCommenFloorItemViewHolder.m.setOnEmotionClickListener(aVar.f57173e);
            pbCommenFloorItemViewHolder.m.setOnVoiceAfterClickListener(this.y);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.q.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.r.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.Z.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.d0.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.a0.setOnClickListener(new e(this, pbCommenFloorItemViewHolder));
            d.a.p0.h2.k.e.c1.c cVar = this.m.z().mPostShareController;
            pbCommenFloorItemViewHolder.s.setOnClickListener(this.y);
            pbCommenFloorItemViewHolder.t.setOnClickListener(new f(this, pbCommenFloorItemViewHolder, cVar));
            pbCommenFloorItemViewHolder.k.z = new g(this, pbCommenFloorItemViewHolder);
            pbCommenFloorItemViewHolder.Y.z = new h(this, pbCommenFloorItemViewHolder);
        }
    }

    @Override // d.a.p0.h2.k.e.o, d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        S0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public void X0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            this.G = z;
        }
    }

    public void Y0(d.a.p0.h2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) {
            this.A = cVar;
        }
    }

    public void Z0(TbRichTextView.r rVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, rVar) == null) {
            this.t = rVar;
        }
    }

    public final void a1(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, pbCommenFloorItemViewHolder) == null) || pbCommenFloorItemViewHolder == null) {
            return;
        }
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (pbCommenFloorItemViewHolder.f19201a != skinType) {
            b1(pbCommenFloorItemViewHolder.f19206f);
            if (d.a.o0.b.d.H()) {
                if (DeviceInfoUtil.isMate30()) {
                    r0.j(pbCommenFloorItemViewHolder.f19205e);
                } else {
                    d.a.o0.r.u.c.d(pbCommenFloorItemViewHolder.f19205e).y(R.string.F_X02);
                }
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19205e, R.color.CAM_X0108, 1);
            } else {
                SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19205e, R.color.CAM_X0109, 1);
            }
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19207g, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19208h, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.f19209i, R.color.CAM_X0109);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.D, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.j, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.r, R.color.CAM_X0108);
            pbCommenFloorItemViewHolder.m.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.b0, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(pbCommenFloorItemViewHolder.c0, R.color.CAM_X0107, 1);
            SubPbLayout subPbLayout = pbCommenFloorItemViewHolder.p;
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds21);
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
                d.a.p0.h2.h.e eVar = this.w;
                if (eVar != null && StringUtils.isNull(eVar.l())) {
                    pbCommenFloorItemViewHolder.S.setText(this.w.l());
                } else {
                    pbCommenFloorItemViewHolder.S.setText(R.string.expand_content);
                }
            }
            pbCommenFloorItemViewHolder.k.u(TbadkCoreApplication.getInst().getSkinType());
            pbCommenFloorItemViewHolder.d(skinType);
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.J, R.color.CAM_X0203);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.Z, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            WebPManager.setPureDrawable(pbCommenFloorItemViewHolder.d0, R.drawable.icon_pure_pb_more18, R.color.CAM_X0109, WebPManager.ResourceStateType.NORMAL_PRESS);
            pbCommenFloorItemViewHolder.c();
        }
        pbCommenFloorItemViewHolder.f19201a = skinType;
    }

    public final void b1(TextView textView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048605, this, textView) == null) || textView == null) {
            return;
        }
        Object tag = textView.getTag();
        if (tag instanceof PostData) {
            c1(textView, (PostData) tag);
        }
    }

    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.u = z;
        }
    }

    public final void c1(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            d.a.p0.h2.h.e eVar = this.w;
            if (eVar != null && eVar.e0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.t() != null) {
                MetaData t = postData.t();
                String str = this.v;
                if (str != null && !str.equals("0") && this.v.equals(t.getUserId())) {
                    textView.setVisibility(0);
                    textView.setAlpha(1.0f);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    d.a.o0.r.u.c d2 = d.a.o0.r.u.c.d(textView);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.t(R.color.CAM_X0302);
                    d2.k(R.color.CAM_X0302);
                } else if (t.getIs_bawu() == 1 && postData.X()) {
                    d.a.o0.r.u.c d3 = d.a.o0.r.u.c.d(textView);
                    d3.t(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (t.getIs_bawu() == 1 && "manager".equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d4 = d.a.o0.r.u.c.d(textView);
                    d4.t(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (t.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d5 = d.a.o0.r.u.c.d(textView);
                    d5.t(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (t.getIs_bawu() == 1 && "pri_content_assist".equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d6 = d.a.o0.r.u.c.d(textView);
                    d6.t(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (t.getIs_bawu() == 1 && "pri_manage_assist".equals(t.getBawu_type())) {
                    d.a.o0.r.u.c d7 = d.a.o0.r.u.c.d(textView);
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

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, onLongClickListener) == null) {
            this.B = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, onClickListener) == null) {
            this.y = onClickListener;
        }
    }

    public void m(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, onClickListener) == null) {
            this.x = onClickListener;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
        }
    }

    public void p(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, xVar) == null) {
            this.z = xVar;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.v = str;
        }
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.A);
            pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
        }
    }

    public void t(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, eVar) == null) {
            this.w = eVar;
        }
    }

    public final void t0(PostData postData) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048616, this, postData) == null) || (eVar = this.w) == null) {
            return;
        }
        if (eVar.l0()) {
            VideoPbFragment videoPbFragment = this.o;
            if (videoPbFragment != null) {
                d.a.p0.h2.m.a.e(videoPbFragment.getUniqueId(), this.w, postData, postData.i0, postData.c0 ? 2 : 8, "common_exp_source_pb_comment");
                return;
            }
            return;
        }
        PbFragment pbFragment = this.n;
        if (pbFragment != null) {
            d.a.p0.h2.m.a.e(pbFragment.getUniqueId(), this.w, postData, postData.i0, postData.c0 ? 2 : 8, "common_exp_source_pb_comment");
        }
    }

    public final void v0(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, postData) == null) && postData.E == 0 && postData.M) {
            StatisticItem statisticItem = new StatisticItem("c12203");
            statisticItem.param("post_id", postData.E());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("cuid", TbadkCoreApplication.getInst().getCuid());
            statisticItem.param("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            statisticItem.param("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            statisticItem.param(TiebaStatic.Params.CUID_GID, TbadkCoreApplication.getInst().getCuidGid());
            statisticItem.param(TiebaStatic.Params.EXPOSURE_TIME, System.currentTimeMillis());
            d.a.p0.h2.o.b bVar = this.m;
            if (bVar != null) {
                int C0 = bVar.y().C0();
                if (1 == C0 || 2 == C0) {
                    statisticItem.param("obj_source", "1");
                } else if (3 == C0) {
                    statisticItem.param("obj_source", "2");
                } else {
                    statisticItem.param("obj_source", "0");
                }
            }
            TiebaStatic.log(statisticItem);
            if (postData.t() == null || postData.t().getAlaInfo() == null || postData.t().getAlaInfo().live_status != 1) {
                return;
            }
            U0(postData);
        }
    }

    public final void w0(TbRichTextView tbRichTextView, View view, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048618, this, tbRichTextView, view, z) == null) || tbRichTextView == null || view == null) {
            return;
        }
        int k = (((d.a.c.e.p.l.k(TbadkCoreApplication.getInst()) - view.getPaddingLeft()) - view.getPaddingRight()) - tbRichTextView.getPaddingLeft()) - tbRichTextView.getPaddingRight();
        if (tbRichTextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) tbRichTextView.getLayoutParams();
            k = (k - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        }
        int f0 = z ? f0(R.dimen.tbds115) : 0;
        tbRichTextView.getLayoutStrategy().q(k - f0);
        tbRichTextView.getLayoutStrategy().D = (k - f0) - f0(R.dimen.tbds122);
        tbRichTextView.getLayoutStrategy().p((int) (k * 1.618f));
    }

    public final void x0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{pbCommenFloorItemViewHolder, Boolean.valueOf(z), str}) == null) {
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

    public final void y0(boolean z, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048620, this, new Object[]{Boolean.valueOf(z), pbCommenFloorItemViewHolder, postData}) == null) || pbCommenFloorItemViewHolder == null || (view = pbCommenFloorItemViewHolder.J) == null || pbCommenFloorItemViewHolder.R == null || !(view.getLayoutParams() instanceof RelativeLayout.LayoutParams) || !(pbCommenFloorItemViewHolder.R.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            return;
        }
        boolean z2 = !ListUtils.isEmpty(postData.M());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.R.getLayoutParams();
        if (z) {
            pbCommenFloorItemViewHolder.m.getLayoutStrategy().m(0);
            if (z2) {
                pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
                }
            } else {
                pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8));
                if (layoutParams2 != null) {
                    layoutParams2.topMargin = 0;
                }
            }
            pbCommenFloorItemViewHolder.R.setLayoutParams(layoutParams2);
            if (layoutParams != null) {
                layoutParams.topMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds20);
                pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().l(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        pbCommenFloorItemViewHolder.m.getLayoutStrategy().m(d.a.c.e.p.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        if (layoutParams != null) {
            layoutParams.topMargin = d.a.c.e.p.l.g(this.f41837e, R.dimen.tbds14);
            pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
        }
    }

    public final void z0(View view) {
        PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
        AgreeView agreeView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048621, this, view) == null) || view == null || !(view.getTag() instanceof PbCommenFloorItemViewHolder) || (agreeView = (pbCommenFloorItemViewHolder = (PbCommenFloorItemViewHolder) view.getTag()).Y) == null || agreeView.getData() == null) {
            return;
        }
        pbCommenFloorItemViewHolder.Y.t();
    }
}
