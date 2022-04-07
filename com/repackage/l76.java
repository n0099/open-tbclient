package com.repackage;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter;
import com.baidu.tieba.enterForum.callback.LikeForumDragCallBack;
import com.baidu.tieba.enterForum.data.ForumCreateInfoData;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c56;
import com.repackage.dr4;
import java.util.List;
/* loaded from: classes6.dex */
public class l76 extends a75<q46, m46> implements h46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View g;
    public TextView h;
    public TextView i;
    public RecyclerView j;
    public LikeForumItemAdapter k;
    public c56 l;
    public EnterForumModel m;
    public ViewEventCenter n;

    /* loaded from: classes6.dex */
    public class a implements c56.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(l76 l76Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l76Var, enterForumModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = enterForumModel;
        }

        @Override // com.repackage.c56.d
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.K(true, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p76 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ l76 c;

        public b(l76 l76Var, p76 p76Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l76Var, p76Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = l76Var;
            this.a = p76Var;
            this.b = itemTouchHelper;
        }

        @Override // com.baidu.tieba.enterForum.adapter.LikeForumItemAdapter.b
        public boolean a(Object obj, RecyclerView.ViewHolder viewHolder) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, viewHolder)) == null) {
                if (this.a.r()) {
                    return false;
                }
                if (this.c.l.p() == 1) {
                    if (obj instanceof p46) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(false);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f09df));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l76 a;

        /* loaded from: classes6.dex */
        public class a implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    dr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    dr4Var.dismiss();
                }
            }
        }

        /* renamed from: com.repackage.l76$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0460c implements dr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0460c(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.repackage.dr4.e
            public void onClick(dr4 dr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dr4Var) == null) {
                    dr4Var.dismiss();
                }
            }
        }

        public c(l76 l76Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l76Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l76Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m.A()) {
                    if (this.a.n != null) {
                        this.a.n.dispatchMvcEvent(new s65(14, null, null, null));
                    }
                } else if (this.a.d() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.m.C().b();
                    if (b2 != null) {
                        int z2 = b2.z();
                        if (z2 == 220012) {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (ni.isEmpty(b2.y())) {
                                y = this.a.d().getString(R.string.obfuscated_res_0x7f0f045f);
                            } else {
                                y = b2.y();
                            }
                            blockPopInfoData.block_info = y;
                            blockPopInfoData.ahead_info = this.a.d().getString(R.string.obfuscated_res_0x7f0f0461);
                            blockPopInfoData.ok_info = this.a.d().getString(R.string.obfuscated_res_0x7f0f0984);
                            blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                            AntiHelper.s(this.a.d().getPageActivity(), blockPopInfoData);
                        } else if (z2 == 2121002) {
                            ty4.b(this.a.d(), null, this.a.d().getString(R.string.obfuscated_res_0x7f0f0463), this.a.d().getString(R.string.obfuscated_res_0x7f0f13f7), this.a.d().getString(R.string.obfuscated_res_0x7f0f1394), new a(this), new b(this)).show();
                        }
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    String string = this.a.d().getString(R.string.obfuscated_res_0x7f0f0460);
                    if (b2 != null) {
                        if (ni.isEmpty(b2.y())) {
                            string = this.a.d().getResources().getString(R.string.obfuscated_res_0x7f0f0460);
                        } else {
                            string = b2.y();
                        }
                    }
                    ty4.b(this.a.d(), null, string, this.a.d().getResources().getString(R.string.obfuscated_res_0x7f0f0984), null, new C0460c(this), null).show();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l76(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, p76 p76Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, p76Var, enterForumModel};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (View) objArr2[1], (ViewEventCenter) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f091244);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092012);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d2f);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a17);
        this.j = recyclerView;
        this.m = enterForumModel;
        this.n = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.j.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.k = likeForumItemAdapter;
        likeForumItemAdapter.f(p());
        this.j.setAdapter(this.k);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.k, this));
        itemTouchHelper.attachToRecyclerView(this.j);
        c56 c56Var = new c56(tbPageContext.getPageActivity(), Integer.valueOf(f46.a(1)).intValue(), 0, p76Var);
        this.l = c56Var;
        c56Var.v(new a(this, enterForumModel));
        this.k.g(new b(this, p76Var, itemTouchHelper));
    }

    @Override // com.repackage.h46
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (enterForumModel = this.m) == null) {
            return;
        }
        enterForumModel.W(str, str2);
    }

    @Override // com.repackage.sj8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            wr4 d = wr4.d(this.g);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            return false;
        }
        return invokeLI.booleanValue;
    }

    public final View.OnClickListener p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.e75
    /* renamed from: q */
    public void i(q46 q46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, q46Var) == null) {
            super.i(q46Var);
            r(q46Var.d);
            List<p46> list = q46Var.e;
            int size = list != null ? 1 + list.size() : 1;
            this.j.getLayoutParams().height = oi.f(getContext(), R.dimen.tbds156) * ((int) Math.ceil((size * 1.0f) / 2.0f));
            this.j.getRecycledViewPool().setMaxRecycledViews(0, size);
            this.k.update(q46Var.e);
            onChangeSkinType(d(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void r(o46 o46Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, o46Var) == null) || o46Var == null) {
            return;
        }
        this.l.w(this.i);
        this.l.s();
        this.l.r(TbadkCoreApplication.getInst().getSkinType());
        this.h.setText(o46Var.d);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        TextView textView = this.i;
        if (textView != null) {
            if (o46Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.i, R.color.transparent);
        }
    }
}
