package com.repackage;

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
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes7.dex */
public class tx7 extends sx7<PostData, PbCommenFloorItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData k;
    public TbRichTextView.s l;
    public boolean m;
    public String n;
    public View.OnClickListener o;
    public TbRichTextView.y p;
    public ls7 q;
    public View.OnLongClickListener r;
    public tw7 s;
    public int t;
    public boolean u;
    public boolean v;
    public eg<ConstrainImageLayout> w;
    public eg<TbImageView> x;

    /* loaded from: classes7.dex */
    public class a implements fg<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public a(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.i.getPageContext().getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements fg<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tx7 a;

        public b(tx7 tx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tx7Var;
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
                TbImageView tbImageView = new TbImageView(this.a.i.getPageContext().getPageActivity());
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
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tx7 b;

        public c(tx7 tx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            SparseArray sparseArray;
            PostData postData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != null && (view2.getTag(R.id.obfuscated_res_0x7f091f34) instanceof Boolean) && view2.getTag(R.id.obfuscated_res_0x7f091f34) == Boolean.TRUE && this.a.b() != null) {
                    this.a.b().setTag(R.id.obfuscated_res_0x7f091f34, Boolean.TRUE);
                }
                this.b.o.onClick(this.a.b());
                if (view2 != null) {
                    view2.setTag(R.id.obfuscated_res_0x7f091f34, null);
                }
                if (this.a.b() != null) {
                    this.a.b().setTag(R.id.obfuscated_res_0x7f091f34, null);
                }
                if (this.a.b() == null || (sparseArray = (SparseArray) this.a.b().getTag(R.id.obfuscated_res_0x7f091f00)) == null || !(sparseArray.get(R.id.obfuscated_res_0x7f091eed) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091eed)) == null || postData.s() == null || postData.p() == null) {
                    return;
                }
                rx7.a(postData.p().threadId, postData.s().getUserId(), postData.J());
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tx7 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ d b;

            public a(d dVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = dVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    d dVar = this.b;
                    tx7 tx7Var = dVar.b;
                    tx7Var.s.b.a(null, tx7Var.k, this.a, dVar.a.n.getLayoutStrategy());
                }
            }
        }

        public d(tx7 tx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f091f09) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091f09)) == null || this.a.b == null || this.b.s == null) {
                    return;
                }
                qg.a().postDelayed(new a(this, postData), 100L);
                String id = this.b.k.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.k.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.k.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.J()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tx7 b;

        public e(tx7 tx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.D) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.D.getImgAgree() ? 1 : 2;
            String id = this.b.k.getId();
            if (StringUtils.isNull(id) || "0".equals(id)) {
                id = this.b.k.getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.k.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.D.getData().postId).param("obj_source", 1).param("obj_type", i));
        }
    }

    /* loaded from: classes7.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tx7 b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PostData a;
            public final /* synthetic */ f b;

            public a(f fVar, PostData postData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, postData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = postData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    f fVar = this.b;
                    tx7 tx7Var = fVar.b;
                    tx7Var.s.b.a(null, tx7Var.k, this.a, fVar.a.n.getLayoutStrategy());
                }
            }
        }

        public f(tx7 tx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PostData postData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof SparseArray)) {
                SparseArray sparseArray = (SparseArray) view2.getTag();
                if (!(sparseArray.get(R.id.obfuscated_res_0x7f091f09) instanceof PostData) || (postData = (PostData) sparseArray.get(R.id.obfuscated_res_0x7f091f09)) == null || this.a.b == null || this.b.s == null) {
                    return;
                }
                qg.a().postDelayed(new a(this, postData), 100L);
                String id = this.b.k.getId();
                if (StringUtils.isNull(id) || "0".equals(id)) {
                    id = this.b.k.getNid();
                }
                TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.k.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", postData.J()).param("obj_source", 1).param("obj_type", 4));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbCommenFloorItemViewHolder a;
        public final /* synthetic */ tx7 b;

        public g(tx7 tx7Var, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tx7Var, pbCommenFloorItemViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tx7Var;
            this.a = pbCommenFloorItemViewHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder;
            AgreeView agreeView;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || view2 == null || this.b.k == null || (pbCommenFloorItemViewHolder = this.a) == null || (agreeView = pbCommenFloorItemViewHolder.l) == null || agreeView.getData() == null) {
                return;
            }
            int i = view2 == this.a.l.getImgAgree() ? 1 : 2;
            String id = this.b.k.getId();
            if (StringUtils.isNull(id) || "0".equals(id)) {
                id = this.b.k.getNid();
            }
            TiebaStatic.log(new StatisticItem("c13700").param("tid", id).param("fid", this.b.k.getFid()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("post_id", this.a.l.getData().postId).param("obj_source", 1).param("obj_type", i));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tx7(NewSubPbActivity newSubPbActivity, BdUniqueId bdUniqueId) {
        super(newSubPbActivity, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {newSubPbActivity, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ws7) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.l = null;
        this.m = zm4.c().g();
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.u = UbsABTestHelper.showTrisectionAndFeedback();
        this.v = false;
        this.w = new eg<>(new a(this), 6, 0);
        this.x = new eg<>(new b(this), 12, 0);
        if (newSubPbActivity == null || newSubPbActivity.d3() == null) {
            return;
        }
        this.t = newSubPbActivity.d3().y0();
    }

    @Override // com.repackage.sx7, com.repackage.an
    public /* bridge */ /* synthetic */ View S(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        i0(i, view2, viewGroup, (PostData) obj, (PbCommenFloorItemViewHolder) viewHolder);
        return view2;
    }

    public final void a0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.n.setTextViewOnTouchListener(this.q);
            pbCommenFloorItemViewHolder.n.setTextViewCheckSelection(false);
        }
    }

    public final void b0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, pbCommenFloorItemViewHolder) == null) {
            if (pbCommenFloorItemViewHolder.K.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams = (RelativeLayout.LayoutParams) pbCommenFloorItemViewHolder.K.getLayoutParams();
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams.height = xs7.i(R.dimen.tbds2);
            layoutParams.leftMargin = xs7.i(R.dimen.tbds148);
            if (this.u) {
                layoutParams.topMargin = xs7.i(R.dimen.tbds0);
            }
            pbCommenFloorItemViewHolder.K.setLayoutParams(layoutParams);
            ColumnLayout columnLayout = (ColumnLayout) pbCommenFloorItemViewHolder.b().findViewById(R.id.obfuscated_res_0x7f090f42);
            if (columnLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
                layoutParams2 = (RelativeLayout.LayoutParams) columnLayout.getLayoutParams();
            } else {
                layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            }
            layoutParams2.leftMargin = xs7.i(R.dimen.tbds21);
            layoutParams2.rightMargin = xs7.i(R.dimen.tbds1);
            columnLayout.setLayoutParams(layoutParams2);
            pbCommenFloorItemViewHolder.n.setCommonTextViewOnClickListener(new c(this, pbCommenFloorItemViewHolder));
        }
    }

    public final void c0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, pbCommenFloorItemViewHolder, postData, i) == null) {
            if (this.u) {
                View view2 = pbCommenFloorItemViewHolder.x;
                if (view2 != null) {
                    SparseArray sparseArray = (SparseArray) view2.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        pbCommenFloorItemViewHolder.x.setTag(sparseArray);
                    }
                    sparseArray.put(R.id.obfuscated_res_0x7f091f09, postData);
                }
                View view3 = pbCommenFloorItemViewHolder.w;
                if (view3 != null) {
                    SparseArray sparseArray2 = (SparseArray) view3.getTag();
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        pbCommenFloorItemViewHolder.w.setTag(sparseArray2);
                    }
                    sparseArray2.put(R.id.obfuscated_res_0x7f091f09, postData);
                }
            }
            ImageView imageView = pbCommenFloorItemViewHolder.t;
            if (imageView != null) {
                SparseArray sparseArray3 = (SparseArray) imageView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    pbCommenFloorItemViewHolder.t.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.obfuscated_res_0x7f091f09, postData);
            }
            ImageView imageView2 = pbCommenFloorItemViewHolder.u;
            if (imageView2 != null) {
                SparseArray sparseArray4 = (SparseArray) imageView2.getTag();
                if (sparseArray4 == null) {
                    sparseArray4 = new SparseArray();
                    pbCommenFloorItemViewHolder.u.setTag(sparseArray4);
                }
                sparseArray4.put(R.id.obfuscated_res_0x7f091f09, postData);
                sparseArray4.put(R.id.obfuscated_res_0x7f091f06, Boolean.valueOf(!postData.l0));
            }
        }
    }

    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, onLongClickListener) == null) {
            this.r = onLongClickListener;
        }
    }

    public final void d0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.W.setVisibility(postData.Z ? 0 : 8);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public final void e0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, View view2, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbCommenFloorItemViewHolder, postData, view2, i) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        pbCommenFloorItemViewHolder.X = i;
        xs7.h(pbCommenFloorItemViewHolder, postData, view2, i, this.i, this.k, this.u, i == 0);
        xs7.e(pbCommenFloorItemViewHolder, postData, this.k, i, this.u);
        if (this.u && postData.l0) {
            pbCommenFloorItemViewHolder.p.setVisibility(8);
            pbCommenFloorItemViewHolder.v.setVisibility(0);
            if (this.k.isUgcThreadType()) {
                pbCommenFloorItemViewHolder.J.setVisibility(8);
            } else {
                pbCommenFloorItemViewHolder.J.setVisibility(0);
            }
        } else {
            pbCommenFloorItemViewHolder.v.setVisibility(8);
            pbCommenFloorItemViewHolder.p.setVisibility(0);
            pbCommenFloorItemViewHolder.t.setVisibility(0);
            pbCommenFloorItemViewHolder.u.setVisibility(0);
            pbCommenFloorItemViewHolder.l.setVisibility(0);
            pbCommenFloorItemViewHolder.J.setVisibility(8);
        }
        xs7.c(pbCommenFloorItemViewHolder, postData, postData.l0, this.u);
        xs7.f(this.i, pbCommenFloorItemViewHolder, postData, view2, this.m, this.j, i != 0, this.l);
        xs7.d(this.i, pbCommenFloorItemViewHolder, postData, this.k);
        xs7.g(pbCommenFloorItemViewHolder, postData);
        xs7.b(pbCommenFloorItemViewHolder, postData, this.m);
        d0(pbCommenFloorItemViewHolder, postData);
    }

    public final void f0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, pbCommenFloorItemViewHolder, postData) == null) || pbCommenFloorItemViewHolder == null || pbCommenFloorItemViewHolder.b == null) {
            return;
        }
        if (StringHelper.equals(this.n, postData.J())) {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0313);
        } else {
            SkinManager.setBackgroundColor(pbCommenFloorItemViewHolder.b, R.color.CAM_X0205);
        }
    }

    public final void g0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder, PostData postData, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048586, this, pbCommenFloorItemViewHolder, postData, i) == null) || pbCommenFloorItemViewHolder == null || postData == null) {
            return;
        }
        if (i == 0) {
            pbCommenFloorItemViewHolder.h(postData.Q, postData.J(), this.v);
        } else {
            pbCommenFloorItemViewHolder.h(postData.p0 == 1, postData.J(), this.v);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: h0 */
    public PbCommenFloorItemViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d069c, viewGroup, false);
            ((ViewGroup) inflate.findViewById(R.id.obfuscated_res_0x7f09178c)).addView(LayoutInflater.from(inflate.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0694, (ViewGroup) null));
            PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder = new PbCommenFloorItemViewHolder(this.i.getPageContext(), inflate, this.t);
            pbCommenFloorItemViewHolder.g(true);
            pbCommenFloorItemViewHolder.o.setConstrainLayoutPool(this.w);
            pbCommenFloorItemViewHolder.o.setImageViewPool(this.x);
            b0(pbCommenFloorItemViewHolder);
            xs7.l(pbCommenFloorItemViewHolder, null, this.u);
            return pbCommenFloorItemViewHolder;
        }
        return (PbCommenFloorItemViewHolder) invokeL.objValue;
    }

    public View i0(int i, View view2, ViewGroup viewGroup, PostData postData, PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbCommenFloorItemViewHolder})) == null) {
            c0(pbCommenFloorItemViewHolder, postData, i);
            j0(pbCommenFloorItemViewHolder);
            a0(pbCommenFloorItemViewHolder);
            PostData postData2 = (PostData) y(i);
            if (postData2 != null) {
                postData2.P0();
                e0(pbCommenFloorItemViewHolder, postData2, view2, i);
                f0(pbCommenFloorItemViewHolder, postData);
                g0(pbCommenFloorItemViewHolder, postData, i);
            }
            xs7.l(pbCommenFloorItemViewHolder, null, this.u);
            pbCommenFloorItemViewHolder.K.setVisibility(i == 0 ? 8 : 0);
            if (postData2 != null && postData2.s() != null && postData2.p() != null) {
                rx7.b("2", String.valueOf(postData2.p().threadId), postData2.s().getUserId(), postData2.J(), postData2.G(), postData2.H());
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void j0(PbCommenFloorItemViewHolder pbCommenFloorItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, pbCommenFloorItemViewHolder) == null) {
            pbCommenFloorItemViewHolder.b.setOnLongClickListener(this.r);
            ws7 ws7Var = this.i;
            if (ws7Var == null || ws7Var.getPageContext().getOrignalPage() == null) {
                return;
            }
            rw7 A0 = this.i.A0();
            if (A0 != null) {
                pbCommenFloorItemViewHolder.f.setOnClickListener(A0.b);
                pbCommenFloorItemViewHolder.m.setOnClickListener(A0.b);
                pbCommenFloorItemViewHolder.G.setOnClickListener(A0.b);
                pbCommenFloorItemViewHolder.G.getHeadView().setOnClickListener(A0.b);
                pbCommenFloorItemViewHolder.n.setOnEmotionClickListener(A0.f);
            }
            pbCommenFloorItemViewHolder.n.setOnLongClickListener(this.r);
            pbCommenFloorItemViewHolder.n.setOnImageClickListener(this.p);
            pbCommenFloorItemViewHolder.n.setOnClickListener(this.o);
            pbCommenFloorItemViewHolder.b().setOnClickListener(this.o);
            pbCommenFloorItemViewHolder.L.setOnClickListener(this.o);
            pbCommenFloorItemViewHolder.M.setOnClickListener(this.o);
            if (this.s == null) {
                this.s = new tw7(this.i.getPageContext());
            }
            if (this.u) {
                pbCommenFloorItemViewHolder.x.setOnClickListener(this.o);
                pbCommenFloorItemViewHolder.w.setOnClickListener(new d(this, pbCommenFloorItemViewHolder));
                pbCommenFloorItemViewHolder.D.x = new e(this, pbCommenFloorItemViewHolder);
            }
            pbCommenFloorItemViewHolder.t.setOnClickListener(this.o);
            pbCommenFloorItemViewHolder.u.setOnClickListener(new f(this, pbCommenFloorItemViewHolder));
            pbCommenFloorItemViewHolder.l.x = new g(this, pbCommenFloorItemViewHolder);
            if (this.u) {
                pbCommenFloorItemViewHolder.J.setOnClickListener(this.o);
            }
        }
    }

    public void k0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.v = z;
        }
    }

    public void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.n = str;
        }
    }

    public void m0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, threadData) == null) {
            this.k = threadData;
        }
    }

    public void o(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yVar) == null) {
            this.p = yVar;
        }
    }
}
