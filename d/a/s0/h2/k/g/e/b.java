package d.a.s0.h2.k.g.e;

import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbCommenFloorItemViewHolder;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.k;
import d.a.r0.r.q.b2;
/* loaded from: classes9.dex */
public class b extends d.a.s0.h2.k.g.e.a<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.c.e.k.b<ConstrainImageLayout> A;
    public d.a.c.e.k.b<TbImageView> B;
    public b2 o;
    public TbRichTextView.r p;
    public boolean q;
    public String r;
    public View.OnClickListener s;
    public TbRichTextView.x t;
    public d.a.s0.h2.i.c u;
    public View.OnLongClickListener v;
    public d.a.s0.h2.k.e.c1.c w;
    public int x;
    public boolean y;
    public boolean z;

    /* loaded from: classes9.dex */
    public class a implements d.a.c.e.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60870a;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60870a = bVar;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f60870a.m.getPageContext().getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* renamed from: d.a.s0.h2.k.g.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1475b implements d.a.c.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f60871a;

        public C1475b(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60871a = bVar;
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
                TbImageView tbImageView = new TbImageView(this.f60871a.m.getPageContext().getPageActivity());
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

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f60872e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60873f;

        public c(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60873f = bVar;
            this.f60872e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view != null && (view.getTag(R.id.tag_subpb_ban_display_keyboard) instanceof Boolean) && view.getTag(R.id.tag_subpb_ban_display_keyboard) == Boolean.TRUE && this.f60872e.a() != null) {
                    this.f60872e.a().setTag(R.id.tag_subpb_ban_display_keyboard, Boolean.TRUE);
                }
                this.f60873f.s.onClick(this.f60872e.a());
                if (view != null) {
                    view.setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
                if (this.f60872e.a() != null) {
                    this.f60872e.a().setTag(R.id.tag_subpb_ban_display_keyboard, null);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f60874e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60875f;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f60876e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ d f60877f;

            public a(d dVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f60877f = dVar;
                this.f60876e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.f60877f;
                    b bVar = dVar.f60875f;
                    bVar.w.f60438b.a(null, bVar.o, this.f60876e, dVar.f60874e.m.getLayoutStrategy());
                }
            }
        }

        public d(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60875f = bVar;
            this.f60874e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f60874e.f19162b == null || this.f60875f.w == null) {
                    return;
                }
                d.a.c.e.m.e.a().postDelayed(new a(this, postData), 100L);
                String c0 = this.f60875f.o.c0();
                if (StringUtils.isNull(c0) || "0".equals(c0)) {
                    c0 = this.f60875f.o.A0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", c0).param("fid", this.f60875f.o.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f60878e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60879f;

        public e(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60879f = bVar;
            this.f60878e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f60879f.o == null || (pbCommenFloorItemViewHolder = this.f60878e) == null || (agreeView = pbCommenFloorItemViewHolder.C) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f60878e.C.getImgAgree() ? 1 : 2;
            String c0 = this.f60879f.o.c0();
            if (StringUtils.isNull(c0) || "0".equals(c0)) {
                c0 = this.f60879f.o.A0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", c0).param("fid", this.f60879f.o.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f60878e.C.getData().postId).param("obj_source", 1).param("obj_type", i2));
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f60880e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60881f;

        /* loaded from: classes9.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ PostData f60882e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ f f60883f;

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
                this.f60883f = fVar;
                this.f60882e = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.f60883f;
                    b bVar = fVar.f60881f;
                    bVar.w.f60438b.a(null, bVar.o, this.f60882e, fVar.f60880e.m.getLayoutStrategy());
                }
            }
        }

        public f(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60881f = bVar;
            this.f60880e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view.getTag();
                if (!(sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.tag_load_sub_data)) == null || this.f60880e.f19162b == null || this.f60881f.w == null) {
                    return;
                }
                d.a.c.e.m.e.a().postDelayed(new a(this, postData), 100L);
                String c0 = this.f60881f.o.c0();
                if (StringUtils.isNull(c0) || "0".equals(c0)) {
                    c0 = this.f60881f.o.A0();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", c0).param("fid", this.f60881f.o.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.E()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbCommenFloorItemViewHolder f60884e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60885f;

        public g(b bVar, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60885f = bVar;
            this.f60884e = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null || this.f60885f.o == null || (pbCommenFloorItemViewHolder = this.f60884e) == null || (agreeView = pbCommenFloorItemViewHolder.k) == null || agreeView.getData() == null) {
                return;
            }
            int i2 = view == this.f60884e.k.getImgAgree() ? 1 : 2;
            String c0 = this.f60885f.o.c0();
            if (StringUtils.isNull(c0) || "0".equals(c0)) {
                c0 = this.f60885f.o.A0();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", c0).param("fid", this.f60885f.o.Q()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.f60884e.k.getData().postId).param("obj_source", 1).param("obj_type", i2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d.a.s0.h2.k.a) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = null;
        this.p = null;
        this.q = k.c().g();
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.y = d.a.r0.b.d.W();
        this.z = false;
        this.A = new d.a.c.e.k.b<>(new a(this), 6, 0);
        this.B = new d.a.c.e.k.b<>(new C1475b(this), 12, 0);
        if (newSubPbActivity == null || newSubPbActivity.getSubPbModel() == null) {
            return;
        }
        this.x = newSubPbActivity.getSubPbModel().h0();
    }

    @Override // d.a.c.k.e.a
    public /* bridge */ /* synthetic */ View X(int i2, View view, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        q0(i2, view, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view;
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onLongClickListener) == null) {
            this.v = onLongClickListener;
        }
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onClickListener) == null) {
            this.s = onClickListener;
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.m.setTextViewOnTouchListener(this.u);
            pbCommenFloorItemViewHolder.m.setTextViewCheckSelection(false);
        }
    }

    public final void h0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.J.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.J.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = d.a.s0.h2.k.b.i(R.dimen.tbds2);
            layoutParams.leftMargin = d.a.s0.h2.k.b.i(R.dimen.tbds148);
            if (this.y) {
                layoutParams.topMargin = d.a.s0.h2.k.b.i(R.dimen.tbds0);
            }
            pbCommenFloorItemViewHolder.J.setLayoutParams(layoutParams);
            ColumnLayout columnLayout = (ColumnLayout) pbCommenFloorItemViewHolder.a().findViewById(R.id.item_head_owner_root);
            if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = d.a.s0.h2.k.b.i(R.dimen.tbds21);
            layoutParams2.rightMargin = d.a.s0.h2.k.b.i(R.dimen.tbds1);
            columnLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.m.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void i0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, pbCommenFloorItemViewHolder, postData, i2) == null) {
            if (this.y) {
                View view = pbCommenFloorItemViewHolder.w;
                if (view != null) {
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        pbCommenFloorItemViewHolder.w.setTag(sparseArray);
                    }
                    sparseArray.put(R.id.tag_load_sub_data, postData);
                }
                View view2 = pbCommenFloorItemViewHolder.v;
                if (view2 != null) {
                    SparseArray sparseArray2 = (SparseArray) view2.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        pbCommenFloorItemViewHolder.v.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.tag_load_sub_data, postData);
                }
            }
            ImageView imageView = pbCommenFloorItemViewHolder.s;
            if (imageView != null) {
                SparseArray sparseArray3 = (SparseArray) imageView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.s.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_load_sub_data, postData);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.t;
            if (imageView2 != null) {
                SparseArray sparseArray4 = (SparseArray) imageView2.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.tag_load_sub_data, postData);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.valueOf(!postData.m0));
            }
        }
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.T.setVisibility(postData.b0 ? 0 : 8);
    }

    public final void k0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData, view, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.U = i2;
        d.a.s0.h2.k.b.h(pbCommenFloorItemViewHolder, postData, view, i2, this.m, this.o, this.y, i2 == 0);
        d.a.s0.h2.k.b.e(pbCommenFloorItemViewHolder, postData, this.o, i2, this.y);
        if (this.y && postData.m0) {
            pbCommenFloorItemViewHolder.o.setVisibility(8);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            if (this.o.p2()) {
                pbCommenFloorItemViewHolder.I.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.I.setVisibility(0);
            }
        } else {
            pbCommenFloorItemViewHolder.u.setVisibility(8);
            pbCommenFloorItemViewHolder.o.setVisibility(0);
            pbCommenFloorItemViewHolder.s.setVisibility(0);
            pbCommenFloorItemViewHolder.t.setVisibility(0);
            pbCommenFloorItemViewHolder.k.setVisibility(0);
            pbCommenFloorItemViewHolder.I.setVisibility(8);
        }
        d.a.s0.h2.k.b.c(pbCommenFloorItemViewHolder, postData, postData.m0, this.y);
        d.a.s0.h2.k.b.f(this.m, pbCommenFloorItemViewHolder, postData, view, this.q, this.n, i2 != 0, this.p);
        d.a.s0.h2.k.b.d(this.m, pbCommenFloorItemViewHolder, postData, this.o);
        d.a.s0.h2.k.b.g(pbCommenFloorItemViewHolder, postData);
        d.a.s0.h2.k.b.b(pbCommenFloorItemViewHolder, postData, this.q);
        j0(pbCommenFloorItemViewHolder, postData);
    }

    public final void l0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.f19162b == null) {
            return;
        }
        if (StringHelper.equals(this.r, postData.E())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19162b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.f19162b, R.color.CAM_X0205);
        }
    }

    public final void m0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048586, this, pbCommenFloorItemViewHolder, postData, i2) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (i2 == 0) {
            pbCommenFloorItemViewHolder.g(postData.S, postData.E(), this.z);
        } else {
            pbCommenFloorItemViewHolder.g(postData.q0 == 1, postData.E(), this.z);
        }
    }

    public void p(TbRichTextView.x xVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, xVar) == null) {
            this.t = xVar;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: p0 */
    public PbCommenFloorItemViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.f44821e).inflate(R.layout.pb_reply_floor_item_layout, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.pb_post_reply_container)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.pb_op_stragtery_default, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.m.getPageContext(), inflate, this.x);
            pbCommenFloorItemViewHolder.f(true);
            pbCommenFloorItemViewHolder.n.setConstrainLayoutPool(this.A);
            pbCommenFloorItemViewHolder.n.setImageViewPool(this.B);
            h0(pbCommenFloorItemViewHolder);
            d.a.s0.h2.k.b.k(pbCommenFloorItemViewHolder, null, this.y);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View q0(int i2, View view, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Integer.valueOf(i2), view, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            i0(pbCommenFloorItemViewHolder, postData, i2);
            s0(pbCommenFloorItemViewHolder);
            g0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) z(i2);
            if (postData2 != null) {
                postData2.B0();
                k0(pbCommenFloorItemViewHolder, postData2, view, i2);
                l0(pbCommenFloorItemViewHolder, postData);
                m0(pbCommenFloorItemViewHolder, postData, i2);
            }
            d.a.s0.h2.k.b.k(pbCommenFloorItemViewHolder, null, this.y);
            pbCommenFloorItemViewHolder.J.setVisibility(i2 == 0 ? 8 : 0);
            return view;
        }
        return (View) invokeCommon.objValue;
    }

    public final void s0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.f19162b.setOnLongClickListener(this.v);
            d.a.s0.h2.k.a aVar = this.m;
            if (aVar == null || aVar.getPageContext().getOrignalPage() == null) {
                return;
            }
            d.a.s0.h2.k.e.c1.a eventController = this.m.getEventController();
            if (eventController != null) {
                pbCommenFloorItemViewHolder.f19165e.setOnClickListener(eventController.f60414b);
                pbCommenFloorItemViewHolder.l.setOnClickListener(eventController.f60414b);
                pbCommenFloorItemViewHolder.F.setOnClickListener(eventController.f60414b);
                pbCommenFloorItemViewHolder.F.getHeadView().setOnClickListener(eventController.f60414b);
                pbCommenFloorItemViewHolder.m.setOnEmotionClickListener(eventController.f60417e);
            }
            pbCommenFloorItemViewHolder.m.setOnLongClickListener(this.v);
            pbCommenFloorItemViewHolder.m.setOnImageClickListener(this.t);
            pbCommenFloorItemViewHolder.m.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.a().setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.K.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.s);
            if (this.w == null) {
                this.w = new d.a.s0.h2.k.e.c1.c(this.m.getPageContext());
            }
            if (this.y) {
                pbCommenFloorItemViewHolder.w.setOnClickListener(this.s);
                pbCommenFloorItemViewHolder.v.setOnClickListener(new d(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.C.z = new e(this, pbCommenFloorItemViewHolder);
            }
            pbCommenFloorItemViewHolder.s.setOnClickListener(this.s);
            pbCommenFloorItemViewHolder.t.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.k.z = new g(this, pbCommenFloorItemViewHolder);
            if (this.y) {
                pbCommenFloorItemViewHolder.I.setOnClickListener(this.s);
            }
        }
    }

    public void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.z = z;
        }
    }

    public void v0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.r = str;
        }
    }

    public void w0(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, b2Var) == null) {
            this.o = b2Var;
        }
    }
}
