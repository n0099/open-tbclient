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
import com.repackage.dq4;
import com.repackage.o36;
import java.util.List;
/* loaded from: classes6.dex */
public class i56 extends n65<f36, b36> implements w26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View f;
    public TextView g;
    public TextView h;
    public RecyclerView i;
    public LikeForumItemAdapter j;
    public o36 k;
    public EnterForumModel l;
    public ViewEventCenter m;

    /* loaded from: classes6.dex */
    public class a implements o36.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ EnterForumModel a;

        public a(i56 i56Var, EnterForumModel enterForumModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var, enterForumModel};
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

        @Override // com.repackage.o36.d
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
        public final /* synthetic */ m56 a;
        public final /* synthetic */ ItemTouchHelper b;
        public final /* synthetic */ i56 c;

        public b(i56 i56Var, m56 m56Var, ItemTouchHelper itemTouchHelper) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var, m56Var, itemTouchHelper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i56Var;
            this.a = m56Var;
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
                if (this.c.k.p() == 1) {
                    if (obj instanceof e36) {
                        this.b.startDrag(viewHolder);
                    }
                } else {
                    Activity currentActivity = TbadkApplication.getInst().getCurrentActivity();
                    if (currentActivity != null) {
                        BdTopToast bdTopToast = new BdTopToast(currentActivity, 2000);
                        bdTopToast.i(false);
                        bdTopToast.h(currentActivity.getString(R.string.obfuscated_res_0x7f0f09ec));
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
        public final /* synthetic */ i56 a;

        /* loaded from: classes6.dex */
        public class a implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements dq4.e {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        /* renamed from: com.repackage.i56$c$c  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0441c implements dq4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0441c(c cVar) {
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

            @Override // com.repackage.dq4.e
            public void onClick(dq4 dq4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, dq4Var) == null) {
                    dq4Var.dismiss();
                }
            }
        }

        public c(i56 i56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String y;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.l.A()) {
                    if (this.a.m != null) {
                        this.a.m.dispatchMvcEvent(new g65(14, null, null, null));
                    }
                } else if (this.a.b() == null) {
                } else {
                    boolean z = false;
                    ForumCreateInfoData b2 = this.a.l.C().b();
                    if (b2 != null) {
                        int z2 = b2.z();
                        if (z2 == 220012) {
                            BlockPopInfoData blockPopInfoData = new BlockPopInfoData();
                            if (ki.isEmpty(b2.y())) {
                                y = this.a.b().getString(R.string.obfuscated_res_0x7f0f046e);
                            } else {
                                y = b2.y();
                            }
                            blockPopInfoData.block_info = y;
                            blockPopInfoData.ahead_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f0470);
                            blockPopInfoData.ok_info = this.a.b().getString(R.string.obfuscated_res_0x7f0f098e);
                            blockPopInfoData.ahead_url = "http://tieba.baidu.com/mo/q/userappeal";
                            AntiHelper.s(this.a.b().getPageActivity(), blockPopInfoData);
                        } else if (z2 == 2121002) {
                            zx4.b(this.a.b(), null, this.a.b().getString(R.string.obfuscated_res_0x7f0f0472), this.a.b().getString(R.string.obfuscated_res_0x7f0f1430), this.a.b().getString(R.string.obfuscated_res_0x7f0f13c9), new a(this), new b(this)).show();
                        }
                        z = true;
                    }
                    if (z) {
                        return;
                    }
                    String string = this.a.b().getString(R.string.obfuscated_res_0x7f0f046f);
                    if (b2 != null) {
                        if (ki.isEmpty(b2.y())) {
                            string = this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f046f);
                        } else {
                            string = b2.y();
                        }
                    }
                    zx4.b(this.a.b(), null, string, this.a.b().getResources().getString(R.string.obfuscated_res_0x7f0f098e), null, new C0441c(this), null).show();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i56(TbPageContext<?> tbPageContext, View view2, ViewEventCenter viewEventCenter, m56 m56Var, EnterForumModel enterForumModel) {
        super(tbPageContext, view2, viewEventCenter);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, viewEventCenter, m56Var, enterForumModel};
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
        this.f = view2.findViewById(R.id.obfuscated_res_0x7f091214);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092017);
        this.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091d34);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f091a1b);
        this.i = recyclerView;
        this.l = enterForumModel;
        this.m = viewEventCenter;
        recyclerView.setNestedScrollingEnabled(false);
        this.i.setLayoutManager(new GridLayoutManager(getContext(), 2));
        LikeForumItemAdapter likeForumItemAdapter = new LikeForumItemAdapter(tbPageContext, null, viewEventCenter);
        this.j = likeForumItemAdapter;
        likeForumItemAdapter.f(m());
        this.i.setAdapter(this.j);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new LikeForumDragCallBack(this.j, this));
        itemTouchHelper.attachToRecyclerView(this.i);
        o36 o36Var = new o36(tbPageContext.getPageActivity(), Integer.valueOf(u26.a(1)).intValue(), 0, m56Var);
        this.k = o36Var;
        o36Var.v(new a(this, enterForumModel));
        this.j.g(new b(this, m56Var, itemTouchHelper));
    }

    @Override // com.repackage.w26
    public void a(String str, String str2) {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, str, str2) == null) || (enterForumModel = this.l) == null) {
            return;
        }
        enterForumModel.W(str, str2);
    }

    public final View.OnClickListener m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c(this) : (View.OnClickListener) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.r65
    /* renamed from: n */
    public void f(f36 f36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f36Var) == null) {
            super.f(f36Var);
            o(f36Var.d);
            List<e36> list = f36Var.e;
            int size = list != null ? 1 + list.size() : 1;
            this.i.getLayoutParams().height = li.f(getContext(), R.dimen.tbds156) * ((int) Math.ceil((size * 1.0f) / 2.0f));
            this.i.getRecycledViewPool().setMaxRecycledViews(0, size);
            this.j.update(f36Var.e);
            onChangeSkinType(b(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public final void o(d36 d36Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, d36Var) == null) || d36Var == null) {
            return;
        }
        this.k.w(this.h);
        this.k.s();
        this.k.r(TbadkCoreApplication.getInst().getSkinType());
        this.g.setText(d36Var.d);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
        TextView textView = this.h;
        if (textView != null) {
            if (d36Var.e) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            SkinManager.setBackgroundColor(this.h, R.color.transparent);
        }
    }

    @Override // com.repackage.xf8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, tbPageContext, i)) == null) {
            wq4 d = wq4.d(this.f);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0205);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0105);
            return false;
        }
        return invokeLI.booleanValue;
    }
}
