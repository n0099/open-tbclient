package d.a.p0.t0.b;

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
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.p0.t0.b.d;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f62296e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.p0.t0.b.c f62297f;

    /* renamed from: g  reason: collision with root package name */
    public final d.a.p0.t0.b.d f62298g;

    /* renamed from: h  reason: collision with root package name */
    public final d.a.p0.t0.b.a f62299h;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<n> f62300i;
    public String j;
    public int k;
    public long l;
    public String m;
    public BaijiahaoData n;
    public OriginalThreadInfo.ShareInfo o;
    public String p;
    public String q;
    public View.OnClickListener r;
    public Runnable s;
    public CustomMessageListener t;
    public CustomMessageListener u;
    public d.b v;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62301e;

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
            this.f62301e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (view.getTag() instanceof d.a.p0.t0.c.b)) {
                Intent intent = new Intent();
                this.f62301e.f62296e.getPageActivity().setResult(-1, intent);
                d.a.p0.t0.c.b bVar = (d.a.p0.t0.c.b) view.getTag();
                if (this.f62301e.k == 1) {
                    this.f62301e.q(bVar.e(), bVar.h());
                } else if (this.f62301e.k == 2) {
                    this.f62301e.s(bVar);
                    TiebaStatic.log(new StatisticItem("c12609").param("fid", bVar.e()));
                } else if (this.f62301e.k != 3) {
                    if (this.f62301e.k == 4) {
                        this.f62301e.r(String.valueOf(bVar.e()), bVar.h());
                    }
                } else {
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(bVar.e()));
                    intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, bVar.h());
                    this.f62301e.f62296e.getPageActivity().finish();
                }
            }
        }
    }

    /* renamed from: d.a.p0.t0.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC1641b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62302e;

        public RunnableC1641b(b bVar) {
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
            this.f62302e = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                l.K(this.f62302e.f62296e.getPageActivity(), this.f62302e.f62297f.f62312d);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62303a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62303a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.f62303a.f62297f.f62312d.setText(str);
                this.f62303a.f62297f.f62312d.setSelection(str.length());
                this.f62303a.n();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62304a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62304a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            this.f62304a.I();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62305a;

        public e(b bVar) {
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
            this.f62305a = bVar;
        }

        @Override // d.a.p0.t0.b.d.b
        public void a(boolean z, d.a.p0.t0.c.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, cVar) == null) {
                if (!z || cVar == null || ListUtils.isEmpty(cVar.a())) {
                    if (StringUtils.isNull(this.f62305a.j)) {
                        this.f62305a.I();
                        return;
                    } else {
                        this.f62305a.J();
                        return;
                    }
                }
                this.f62305a.f62300i = cVar.a();
                b bVar = this.f62305a;
                bVar.v(bVar.f62300i);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f62306a;

        public f(b bVar) {
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
            this.f62306a = bVar;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) {
                if (i2 == 3) {
                    this.f62306a.n();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62307e;

        public g(b bVar) {
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
            this.f62307e = bVar;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.f62307e.n();
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f62308e;

        public h(b bVar) {
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
            this.f62308e = bVar;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view, z) == null) {
                if (!z) {
                    l.x(this.f62308e.f62296e.getPageActivity(), view);
                } else {
                    this.f62308e.n();
                }
            }
        }
    }

    public b(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new a(this);
        this.s = new RunnableC1641b(this);
        this.t = new c(this, 2921021);
        this.u = new d(this, 2921020);
        this.v = new e(this);
        this.f62296e = tbPageContext;
        this.f62297f = new d.a.p0.t0.b.c(tbPageContext);
        m();
        d.a.p0.t0.b.d dVar = new d.a.p0.t0.b.d(tbPageContext, tbPageContext.getUniqueId());
        this.f62298g = dVar;
        dVar.e(this.v);
        this.f62300i = new ArrayList<>();
        d.a.p0.t0.b.a aVar = new d.a.p0.t0.b.a(tbPageContext, this.f62297f.f62315g);
        this.f62299h = aVar;
        aVar.a(this.r);
        I();
        tbPageContext.registerListener(this.u);
        tbPageContext.registerListener(this.t);
        d.a.c.e.m.e.a().postDelayed(this.s, 500L);
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public void B(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareInfo) == null) {
            this.o = shareInfo;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.q = str;
        }
    }

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.m = str;
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f62298g.c();
            this.f62300i.clear();
            ArrayList<String> c2 = d.a.p0.t0.b.e.c();
            if (!ListUtils.isEmpty(c2)) {
                d.a.p0.t0.c.a aVar = new d.a.p0.t0.c.a();
                aVar.d(d.a.p0.t0.c.a.f62324h);
                this.f62300i.add(aVar);
                this.f62300i.add(new d.a.p0.t0.c.a(c2));
                v(this.f62300i);
                return;
            }
            this.f62300i.clear();
            v(this.f62300i);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f62300i.clear();
            d.a.p0.t0.c.a aVar = new d.a.p0.t0.c.a();
            aVar.d(d.a.p0.t0.c.a.f62325i);
            this.f62300i.add(aVar);
            v(this.f62300i);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f62297f.f62310b.setOnClickListener(this);
            this.f62297f.f62312d.setOnEditorActionListener(new f(this));
            this.f62297f.f62312d.addTextChangedListener(new g(this));
            this.f62297f.f62312d.setOnFocusChangeListener(new h(this));
            this.f62297f.f62312d.setOnClickListener(this);
            this.f62297f.f62313e.setOnClickListener(this);
            this.f62297f.f62314f.setOnClickListener(this);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.f62297f.f62312d.getText() != null && !StringUtils.isNull(this.f62297f.f62312d.getText().toString())) {
                n nVar = (n) ListUtils.getItem(this.f62300i, 0);
                if (nVar != null && nVar.getType() == d.a.p0.t0.c.a.f62324h) {
                    this.f62300i.clear();
                    v(this.f62300i);
                }
                this.f62297f.f62313e.setVisibility(0);
                String obj = this.f62297f.f62312d.getText().toString();
                this.j = obj;
                this.f62298g.d(obj);
                return;
            }
            this.f62297f.f62313e.setVisibility(8);
            this.j = null;
            I();
        }
    }

    public d.a.p0.t0.b.c o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f62297f : (d.a.p0.t0.b.c) invokeV.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            d.a.p0.t0.b.c cVar = this.f62297f;
            EditText editText = cVar.f62312d;
            if (view == editText) {
                n();
            } else if (view == cVar.f62314f) {
                l.x(this.f62296e.getPageActivity(), this.f62297f.f62312d);
                this.f62296e.getPageActivity().finish();
            } else if (view == cVar.f62313e) {
                editText.setText("");
            } else if (view == cVar.f62310b) {
                v(this.f62300i);
            }
        }
    }

    public final FrsTabInfoData p(d.a.p0.t0.c.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bVar)) == null) {
            if (bVar == null || ListUtils.isEmpty(bVar.j())) {
                return null;
            }
            ArrayList arrayList = new ArrayList(bVar.j().size());
            for (FrsTabInfo frsTabInfo : bVar.j()) {
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

    public final void q(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048588, this, j, str) == null) {
            TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
            transmitForumData.tabItemDatas = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(transmitForumData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.f62296e.getPageActivity(), arrayList, String.valueOf(this.l), this.m)));
            this.f62296e.getPageActivity().finish();
        }
    }

    public final void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, str, str2) == null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.f62296e.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.f62296e.getPageActivity().finish();
    }

    public final void s(d.a.p0.t0.c.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bVar) == null) || bVar == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.f62296e.getPageActivity(), 9, String.valueOf(bVar.e()), bVar.h(), null, null, 13011, null, null, null, this.o);
        transmitPostEditActivityConfig.setCallFrom("2");
        transmitPostEditActivityConfig.setBaijiahaoData(this.n);
        transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.p);
        transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.q);
        transmitPostEditActivityConfig.setFrsTabInfo(p(bVar));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.f62296e.getPageActivity().finish();
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            d.a.c.e.m.e.a().removeCallbacks(this.s);
            MessageManager.getInstance().unRegisterListener(this.u);
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    public void u(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, baijiahaoData) == null) {
            this.n = baijiahaoData;
        }
    }

    public void v(ArrayList<n> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) {
            this.f62300i = arrayList;
            this.f62297f.f62315g.setData(arrayList);
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.k = i2;
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.l = j;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
        }
    }
}
