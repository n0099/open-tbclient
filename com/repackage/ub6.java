package com.repackage;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.wb6;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class ub6 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public final vb6 b;
    public final wb6 c;
    public final tb6 d;
    public ArrayList<ro> e;
    public String f;
    public int g;
    public long h;
    public String i;
    public BaijiahaoData j;
    public OriginalThreadInfo.ShareInfo k;
    public String l;
    public String m;
    public View.OnClickListener n;
    public Runnable o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public wb6.b r;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        public a(ub6 ub6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (view2.getTag() instanceof zb6)) {
                Intent intent = new Intent();
                this.a.a.getPageActivity().setResult(-1, intent);
                zb6 zb6Var = (zb6) view2.getTag();
                if (this.a.g == 1) {
                    this.a.r(zb6Var.i(), zb6Var.k());
                } else if (this.a.g == 2) {
                    this.a.t(zb6Var);
                    TiebaStatic.log(new StatisticItem("c12609").param("fid", zb6Var.i()));
                } else if (this.a.g != 3) {
                    if (this.a.g == 4) {
                        this.a.s(String.valueOf(zb6Var.i()), zb6Var.k());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(zb6Var.i()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, zb6Var.k());
                    this.a.a.getPageActivity().finish();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        public b(ub6 ub6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                mi.L(this.a.a.getPageActivity(), this.a.b.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ub6 ub6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.b.d.setText(str);
                this.a.b.d.setSelection(str.length());
                this.a.n();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ub6 ub6Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.a.G();
        }
    }

    /* loaded from: classes7.dex */
    public class e implements wb6.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        public e(ub6 ub6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        @Override // com.repackage.wb6.b
        public void a(boolean z, ac6 ac6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, ac6Var) == null) {
                if (!z || ac6Var == null || ListUtils.isEmpty(ac6Var.a())) {
                    if (StringUtils.isNull(this.a.f)) {
                        this.a.G();
                        return;
                    } else {
                        this.a.H();
                        return;
                    }
                }
                this.a.e = ac6Var.a();
                ub6 ub6Var = this.a;
                ub6Var.w(ub6Var.e);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        public f(ub6 ub6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 3) {
                    this.a.n();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        public g(ub6 ub6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.n();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ub6 a;

        public h(ub6 ub6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ub6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ub6Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (!z) {
                    mi.w(this.a.a.getPageActivity(), view2);
                } else {
                    this.a.n();
                }
            }
        }
    }

    public ub6(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new a(this);
        this.o = new b(this);
        this.p = new c(this, 2921021);
        this.q = new d(this, 2921020);
        this.r = new e(this);
        this.a = tbPageContext;
        this.b = new vb6(tbPageContext);
        m();
        wb6 wb6Var = new wb6(tbPageContext, tbPageContext.getUniqueId());
        this.c = wb6Var;
        wb6Var.e(this.r);
        this.e = new ArrayList<>();
        tb6 tb6Var = new tb6(tbPageContext, this.b.g);
        this.d = tb6Var;
        tb6Var.a(this.n);
        G();
        tbPageContext.registerListener(this.q);
        tbPageContext.registerListener(this.p);
        ng.a().postDelayed(this.o, 500L);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
        }
    }

    public void C(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, shareInfo) == null) {
            this.k = shareInfo;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.l = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.i = str;
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.c.c();
            this.e.clear();
            ArrayList<String> c2 = xb6.c();
            if (!ListUtils.isEmpty(c2)) {
                yb6 yb6Var = new yb6();
                yb6Var.g(yb6.d);
                this.e.add(yb6Var);
                this.e.add(new yb6(c2));
                w(this.e);
                return;
            }
            this.e.clear();
            w(this.e);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.clear();
            yb6 yb6Var = new yb6();
            yb6Var.g(yb6.e);
            this.e.add(yb6Var);
            w(this.e);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.b.b.setOnClickListener(this);
            this.b.d.setOnEditorActionListener(new f(this));
            this.b.d.addTextChangedListener(new g(this));
            this.b.d.setOnFocusChangeListener(new h(this));
            this.b.d.setOnClickListener(this);
            this.b.e.setOnClickListener(this);
            this.b.f.setOnClickListener(this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.b.d.getText() != null && !StringUtils.isNull(this.b.d.getText().toString())) {
                ro roVar = (ro) ListUtils.getItem(this.e, 0);
                if (roVar != null && roVar.getType() == yb6.d) {
                    this.e.clear();
                    w(this.e);
                }
                this.b.e.setVisibility(0);
                String obj = this.b.d.getText().toString();
                this.f = obj;
                this.c.d(obj);
                return;
            }
            this.b.e.setVisibility(8);
            this.f = null;
            G();
        }
    }

    public vb6 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (vb6) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, view2) == null) {
            vb6 vb6Var = this.b;
            EditText editText = vb6Var.d;
            if (view2 == editText) {
                n();
            } else if (view2 == vb6Var.f) {
                mi.w(this.a.getPageActivity(), this.b.d);
                this.a.getPageActivity().finish();
            } else if (view2 == vb6Var.e) {
                editText.setText("");
            } else if (view2 == vb6Var.b) {
                w(this.e);
            }
        }
    }

    public final FrsTabInfoData q(zb6 zb6Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, zb6Var)) == null) {
            if (zb6Var == null || ListUtils.isEmpty(zb6Var.m())) {
                return null;
            }
            ArrayList arrayList = new ArrayList(zb6Var.m().size());
            for (FrsTabInfo frsTabInfo : zb6Var.m()) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = -1;
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeL.objValue;
    }

    public final void r(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048589, this, j, str) == null) {
            TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
            transmitForumData.tabItemDatas = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(transmitForumData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.a.getPageActivity(), arrayList, String.valueOf(this.h), this.i)));
            this.a.getPageActivity().finish();
        }
    }

    public final void s(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.a.getPageActivity().finish();
    }

    public final void t(zb6 zb6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, zb6Var) == null) || zb6Var == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.a.getPageActivity(), 9, String.valueOf(zb6Var.i()), zb6Var.k(), null, null, com.kuaishou.weapon.un.w0.B6, null, null, null, this.k);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.j);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.l);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.m);
        transmitPostEditActivityConfig.setFrsTabInfo(q(zb6Var));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.a.getPageActivity().finish();
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            ng.a().removeCallbacks(this.o);
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public void v(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, baijiahaoData) == null) {
            this.j = baijiahaoData;
        }
    }

    public void w(ArrayList<ro> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, arrayList) == null) {
            this.e = arrayList;
            this.b.g.setData(arrayList);
        }
    }

    public void x(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.g = i;
        }
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.h = j;
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }
}
