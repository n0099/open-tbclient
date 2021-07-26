package d.a.q0.j1.a.b.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.RequestUpdateMaskInfoMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseQueryUserInfoMessage;
import com.baidu.tieba.im.model.BlackListModel;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.tieba.imMessageCenter.RequestQueryUserInfoMessage;
import com.baidu.tieba.imMessageCenter.im.chat.personaltalk.PersonalTalkSettingActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.b1.f0;
import d.a.p0.b1.i0;
import d.a.p0.b1.n;
import protobuf.QueryUserInfos.DataRes;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.p0.t.e.a f59475a;

    /* renamed from: b  reason: collision with root package name */
    public DataRes f59476b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59477c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59478d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f59479e;

    /* renamed from: f  reason: collision with root package name */
    public BdUniqueId f59480f;

    /* renamed from: g  reason: collision with root package name */
    public final BlackListModel f59481g;

    /* renamed from: h  reason: collision with root package name */
    public PersonalTalkSettingActivity f59482h;

    /* renamed from: i  reason: collision with root package name */
    public e f59483i;
    public d.a.d.c.g.c j;
    public CustomMessageListener k;

    /* loaded from: classes8.dex */
    public class a extends f0<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f59484a;

        public a(f fVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59484a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.f0
        /* renamed from: a */
        public PersonalSettingItemData doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? d.a.q0.i1.t.e.j().a(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.f59484a)) : (PersonalSettingItemData) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements n<PersonalSettingItemData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f59485a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PersonalTalkSettingActivity f59486b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f59487c;

        public b(f fVar, long j, PersonalTalkSettingActivity personalTalkSettingActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Long.valueOf(j), personalTalkSettingActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f59487c = fVar;
            this.f59485a = j;
            this.f59486b = personalTalkSettingActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(PersonalSettingItemData personalSettingItemData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, personalSettingItemData) == null) {
                if (personalSettingItemData != null) {
                    this.f59487c.f59479e = personalSettingItemData.isAcceptNotify();
                }
                RequestQueryUserInfoMessage requestQueryUserInfoMessage = new RequestQueryUserInfoMessage();
                requestQueryUserInfoMessage.setReqUserId(this.f59485a);
                this.f59486b.sendMessage(requestQueryUserInfoMessage);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends d.a.d.c.g.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f59488a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f59488a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            int cmd = socketResponsedMessage.getCmd();
            if (cmd == 104102) {
                if (socketResponsedMessage instanceof ResponsedMessage) {
                    this.f59488a.f59482h.closeLoadingDialog();
                    if (socketResponsedMessage.getError() != 0) {
                        this.f59488a.f59482h.showToast(socketResponsedMessage.getErrorString());
                    }
                }
                if (socketResponsedMessage instanceof ResponseUpdateMaskInfoMessage) {
                    ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage;
                    if (responseUpdateMaskInfoMessage.getOrginalMessage() instanceof RequestUpdateMaskInfoMessage) {
                        RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = (RequestUpdateMaskInfoMessage) responseUpdateMaskInfoMessage.getOrginalMessage();
                        if (requestUpdateMaskInfoMessage.getMaskType() == 10) {
                            this.f59488a.f59478d = requestUpdateMaskInfoMessage.getIsMask() == 1;
                            if (this.f59488a.f59483i != null) {
                                this.f59488a.f59483i.updateUI();
                            }
                        }
                    }
                }
            } else if (cmd != 205003) {
            } else {
                if ((socketResponsedMessage instanceof ResponsedMessage) && socketResponsedMessage.getError() != 0) {
                    this.f59488a.f59482h.hideProgressBar();
                    this.f59488a.f59482h.showToast(socketResponsedMessage.getErrorString());
                } else if (socketResponsedMessage instanceof ResponseQueryUserInfoMessage) {
                    ResponseQueryUserInfoMessage responseQueryUserInfoMessage = (ResponseQueryUserInfoMessage) socketResponsedMessage;
                    if (responseQueryUserInfoMessage.getResData() != null) {
                        this.f59488a.f59476b = responseQueryUserInfoMessage.getResData();
                        f fVar = this.f59488a;
                        fVar.f59477c = fVar.f59476b.hasConcerned.intValue() == 1;
                        f fVar2 = this.f59488a;
                        fVar2.f59478d = fVar2.f59476b.isBlacklist.intValue() == 1;
                        this.f59488a.f59482h.hideProgressBar();
                        if (this.f59488a.f59483i != null) {
                            this.f59488a.f59483i.updateUI();
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f59489a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(f fVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, Integer.valueOf(i2)};
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
            this.f59489a = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (!updateAttentionMessage.isSucc()) {
                    if (this.f59489a.f59482h == null || TextUtils.isEmpty(updateAttentionMessage.getErrorString())) {
                        return;
                    }
                    this.f59489a.f59482h.showToast(updateAttentionMessage.getErrorString());
                    return;
                }
                this.f59489a.f59477c = updateAttentionMessage.isAttention();
                if (this.f59489a.f59482h != null) {
                    if (this.f59489a.f59477c) {
                        this.f59489a.f59482h.showToast(R.string.add_success);
                    } else {
                        this.f59489a.f59482h.showToast(R.string.remove_succ);
                    }
                }
                if (this.f59489a.f59483i != null) {
                    this.f59489a.f59483i.updateUI();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface e {
        void updateUI();
    }

    public f(PersonalTalkSettingActivity personalTalkSettingActivity, e eVar, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personalTalkSettingActivity, eVar, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59477c = false;
        this.f59478d = false;
        this.f59479e = false;
        this.f59480f = BdUniqueId.gen();
        this.j = new c(this, 0);
        this.k = new d(this, 0);
        this.f59482h = personalTalkSettingActivity;
        this.f59483i = eVar;
        this.f59475a = new d.a.p0.t.e.a(personalTalkSettingActivity.getPageContext());
        this.f59481g = new BlackListModel(personalTalkSettingActivity.getPageContext());
        personalTalkSettingActivity.showProgressBar();
        i0.c(new a(this, j), new b(this, j, personalTalkSettingActivity));
    }

    public CustomMessageListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (CustomMessageListener) invokeV.objValue;
    }

    public DataRes j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f59476b : (DataRes) invokeV.objValue;
    }

    public d.a.d.c.g.c k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : (d.a.d.c.g.c) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59478d : invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59479e : invokeV.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.a.p0.t.e.a aVar = this.f59475a;
            if (aVar != null) {
                aVar.g();
            }
            BlackListModel blackListModel = this.f59481g;
            if (blackListModel != null) {
                blackListModel.cancelLoadData();
            }
        }
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f59479e = z;
        }
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            RequestUpdateMaskInfoMessage requestUpdateMaskInfoMessage = new RequestUpdateMaskInfoMessage();
            requestUpdateMaskInfoMessage.setMaskType(9);
            requestUpdateMaskInfoMessage.setList(String.valueOf(this.f59476b.id));
            requestUpdateMaskInfoMessage.setSettingMask(z);
            requestUpdateMaskInfoMessage.setTag(this.f59480f);
            MessageManager.getInstance().removeMessage(104102, this.f59480f);
            MessageManager.getInstance().sendMessage(requestUpdateMaskInfoMessage);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.f59482h.showLoadingDialog(null);
            if (z) {
                this.f59481g.addToBlackList(this.f59476b.id.longValue());
            } else {
                this.f59481g.removeFromBlackList(this.f59476b.id.longValue());
            }
        }
    }
}
