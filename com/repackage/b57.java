package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.MsgLeftViewItemAdapter;
import com.baidu.tieba.im.chat.MsgMidViewItemAdapter;
import com.baidu.tieba.im.chat.MsgRightViewItemAdapter;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class b57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<MsglistActivity<?>> a;
    public List<ChatMessage> b;
    public BdTypeListView c;
    public MsgLeftViewItemAdapter d;
    public MsgRightViewItemAdapter e;
    public MsgMidViewItemAdapter f;
    public List<MsgCommonItemAdapter> g;
    public CustomMessageListener h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b57 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b57 b57Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b57Var, Integer.valueOf(i)};
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
            this.a = b57Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.b == null || aVar.a == null) {
                return;
            }
            this.a.g.addAll(aVar.b);
            this.a.c.a(new ArrayList(this.a.g));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b57(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (BdTypeListView) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<ChatMessage> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.a, ChatMessage.TYPE_MSG_LEFT);
            this.d = msgLeftViewItemAdapter;
            msgLeftViewItemAdapter.e0(true);
            this.d.f0(true);
            MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.a, ChatMessage.TYPE_MSG_RIGHT);
            this.e = msgRightViewItemAdapter;
            msgRightViewItemAdapter.e0(true);
            this.e.f0(true);
            this.f = new MsgMidViewItemAdapter(this.a, ChatMessage.TYPE_MSG_MID);
            this.g.add(this.d);
            this.g.add(this.e);
            this.g.add(this.f);
            e();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.b = new ArrayList();
            aVar.a = this.a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.h.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.h);
        }
    }

    public void f(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) && (this.c.getAdapter2() instanceof lo)) {
            this.c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.c.getAdapter2() instanceof lo)) {
            this.c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (this.c.getAdapter2() instanceof lo)) {
            this.c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.h == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.h);
        this.h = null;
    }

    public void j(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.b = list;
            ArrayList arrayList = new ArrayList();
            if (this.b != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        if (list.get(i).getCacheData() == null) {
                            list.get(i).setCacheData(new MsgCacheData());
                        }
                        list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                    }
                }
                arrayList.addAll(this.b);
            }
            this.c.setData(arrayList);
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.d;
            if (msgLeftViewItemAdapter != null) {
                msgLeftViewItemAdapter.d0(z);
            }
            MsgRightViewItemAdapter msgRightViewItemAdapter = this.e;
            if (msgRightViewItemAdapter != null) {
                msgRightViewItemAdapter.d0(z);
            }
        }
    }

    public void l(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048585, this, z) == null) || (msgRightViewItemAdapter = this.e) == null) {
            return;
        }
        msgRightViewItemAdapter.m0(z);
    }

    public void m(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (msgLeftViewItemAdapter = this.d) == null) {
            return;
        }
        msgLeftViewItemAdapter.m0(z);
    }

    public void n(ef efVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, efVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.g) {
                if (msgCommonItemAdapter.a0()) {
                    msgCommonItemAdapter.g0(efVar);
                }
            }
        }
    }

    public void o(ff ffVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ffVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.g) {
                if (msgCommonItemAdapter.b0()) {
                    msgCommonItemAdapter.h0(ffVar);
                }
            }
        }
    }

    public void p(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) {
            this.e.i0(arrayList);
            this.d.i0(arrayList);
        }
    }

    public void q(AbsMsglistView.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gVar) == null) {
            this.d.k0(gVar);
            this.e.k0(gVar);
        }
    }

    public b57(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.g = new ArrayList();
        this.h = new a(this, 2001275);
        this.a = tbPageContext;
        this.c = bdTypeListView;
        d();
        this.d.j0(i);
        this.e.j0(i);
    }
}
