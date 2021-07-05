package d.a.r0.f0.q;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.LocationSocketRequestMessage;
import com.baidu.tieba.tbadkCore.location.LocationSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.c.g.c;
import d.a.r0.f0.b;
import d.a.r0.f0.h;
/* loaded from: classes9.dex */
public class a implements b<LocationEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f55307a;

    /* renamed from: d.a.r0.f0.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1242a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1242a(a aVar, int i2, boolean z) {
            super(i2, z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Boolean) objArr2[1]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            LocationData locationData;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) || socketResponsedMessage == null) {
                return;
            }
            LocationEvent locationEvent = new LocationEvent();
            locationEvent.setType(1);
            locationEvent.eventType = 1;
            locationEvent.errorCode = socketResponsedMessage.getError();
            locationEvent.errorMsg = socketResponsedMessage.getErrorString();
            if (socketResponsedMessage instanceof LocationSocketResponsedMessage) {
                locationEvent.locationData = ((LocationSocketResponsedMessage) socketResponsedMessage).getLocationData();
            }
            if (socketResponsedMessage.getError() == 0 && (locationData = locationEvent.locationData) != null) {
                LocationModel.A(locationData);
                d.a.s0.h3.m0.b.a().g(System.currentTimeMillis());
                d.a.s0.h3.m0.b.a().e(locationEvent.locationData);
            }
            h.i(locationEvent);
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55307a = new C1242a(this, 303017, true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.r0.f0.b
    /* renamed from: a */
    public boolean onEvent(LocationEvent locationEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, locationEvent)) == null) {
            if (locationEvent == null) {
                return false;
            }
            if (locationEvent.getType() == 3) {
                MessageManager.getInstance().unRegisterListener(this.f55307a);
                MessageManager.getInstance().registerListener(this.f55307a);
                LocationSocketRequestMessage locationSocketRequestMessage = new LocationSocketRequestMessage();
                locationSocketRequestMessage.setLat(locationEvent.lat);
                locationSocketRequestMessage.setLng(locationEvent.lng);
                MessageManager.getInstance().sendMessage(locationSocketRequestMessage);
            } else if (locationEvent.eventType == 1) {
                LocationSocketResponsedMessage locationSocketResponsedMessage = new LocationSocketResponsedMessage();
                locationSocketResponsedMessage.setError(locationEvent.errorCode);
                locationSocketResponsedMessage.setErrorString(locationEvent.errorMsg);
                locationSocketResponsedMessage.setLocationData(locationEvent.locationData);
                MessageManager.getInstance().dispatchResponsedMessage(locationSocketResponsedMessage);
            } else if (locationEvent.locationData != null && locationEvent.needRefresh) {
                d.a.s0.h3.m0.b.a().e(locationEvent.locationData);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(locationEvent.isShowLocation, locationEvent.locName, locationEvent.locAddr, locationEvent.locSn));
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
