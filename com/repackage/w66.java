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
import com.repackage.nr4;
import java.util.List;
/* loaded from: classes7.dex */
public class w66 extends q75<t46, p46> implements k46 {
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

    /* loaded from: classes7.dex */
    public class a implements c56.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(w66 w66Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w66Var, enterForumModel};
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

    /* loaded from: classes7.dex */
    public class b implements LikeForumItemAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a76 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ w66 c;

        public b(w66 w66Var, a76 a76Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w66Var, a76Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = w66Var;
            this.a = a76Var;
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
                    if (obj instanceof s46) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(false);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f09e5));
                        bdTopToast.j((ViewGroup) currentActivity.findViewById(16908290));
                    }
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w66 a;

        /* loaded from: classes7.dex */
        public class a implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements nr4.e {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        /* renamed from: com.repackage.w66$c$c  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class C0541c implements nr4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0541c(c cVar) {
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

            @Override // com.repackage.nr4.e
            public void onClick(nr4 nr4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, nr4Var) == null) {
                    nr4Var.dismiss();
                }
            }
        }

        public c(w66 w66Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {w66Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = w66Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.m.A()) {
                    if (this.a.n != null) {
                        this.a.n.dispatchMvcEvent(new i75(14, null, null, null));
                    }
                } else if (this.a.d() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.m.C().b();
                    if (b2 != null) {
                        int z2 = b2.z();
                        if (z2 == 220012) {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (li.isEmpty(b2.y())) {
                                y = this.a.d().getString(R.string.obfuscated_res_0x7f0f0467);
                            } else {
                                y = b2.y();
                            }
                            blockPopInfoData.block_info = y;
                            blockPopInfoData.ahead_info = this.a.d().getString(R.string.obfuscated_res_0x7f0f0469);
                            blockPopInfoData.ok_info = this.a.d().getString(R.string.obfuscated_res_0x7f0f0988);
                            blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                            AntiHelper.s(this.a.d().getPageActivity(), blockPopInfoData);
                        } else if (z2 == 2121002) {
                            gz4.b(this.a.d(), null, this.a.d().getString(R.string.obfuscated_res_0x7f0f046b), this.a.d().getString(R.string.obfuscated_res_0x7f0f141e), this.a.d().getString(R.string.obfuscated_res_0x7f0f13b7), new a(this), new b(this)).show();
                        }
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    String string = this.a.d().getString(R.string.obfuscated_res_0x7f0f0468);
                    if (b2 != null) {
                        if (li.isEmpty(b2.y())) {
                            string = this.a.d().getResources().getString(R.string.obfuscated_res_0x7f0f0468);
                        } else {
                            string = b2.y();
                        }
                    }
                    gz4.b(this.a.d(), null, string, this.a.d().getResources().getString(R.string.obfuscated_res_0x7f0f0988), null, new C0541c(this), null).show();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w66(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, a76 a76Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, a76Var, enterForumModel};
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
        this.g = view2.findViewById(R.id.obfuscated_res_0x7f091252);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092071);
        this.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d89);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a6a);
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
        c56 c56Var = new c56(tbPageContext.getPageActivity(), Integer.valueOf(i46.a(1)).intValue(), 0, a76Var);
        this.l = c56Var;
        c56Var.v(new a(this, enterForumModel));
        this.k.g(new b(this, a76Var, itemTouchHelper));
    }

    @Override // com.repackage.k46
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (enterForumModel = this.m) == null) {
            return;
        }
        enterForumModel.W(str, str2);
    }

    @Override // com.repackage.wi8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i)) == null) {
            gs4 d = gs4.d(this.g);
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
    @Override // com.repackage.u75
    /* renamed from: q */
    public void i(t46 t46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, t46Var) == null) {
            super.i(t46Var);
            r(t46Var.d);
            List<s46> list = t46Var.e;
            int size = list != null ? 1 + list.size() : 1;
            this.j.getLayoutParams().height = mi.f(getContext(), R.dimen.tbds156) * ((int) Math.ceil((size * 1.0f) / 2.0f));
            this.j.getRecycledViewPool().setMaxRecycledViews(0, size);
            this.k.update(t46Var.e);
            onChangeSkinType(d(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void r(r46 r46Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, r46Var) == null) || r46Var == null) {
            return;
        }
        this.l.w(this.i);
        this.l.s();
        this.l.r(TbadkCoreApplication.getInst().getSkinType());
        this.h.setText(r46Var.d);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
        TextView textView = this.i;
        if (textView != null) {
            if (r46Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.i, R.color.transparent);
        }
    }
}
