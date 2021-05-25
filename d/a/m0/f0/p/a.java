package d.a.m0.f0.p;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.tbadkCore.location.LocationSocketRequestMessage;
import com.baidu.tieba.tbadkCore.location.LocationSocketResponsedMessage;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import d.a.c.c.g.c;
import d.a.m0.f0.b;
import d.a.m0.f0.h;
/* loaded from: classes3.dex */
public class a implements b<LocationEvent> {

    /* renamed from: a  reason: collision with root package name */
    public c f49390a = new C1123a(this, 303017, true);

    /* renamed from: d.a.m0.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1123a extends c {
        public C1123a(a aVar, int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            LocationData locationData;
            if (socketResponsedMessage == null) {
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
                LocationModel.w(locationData);
                d.a.n0.e3.m0.b.a().g(System.currentTimeMillis());
                d.a.n0.e3.m0.b.a().e(locationEvent.locationData);
            }
            h.i(locationEvent);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.f0.b
    /* renamed from: a */
    public boolean onEvent(LocationEvent locationEvent) {
        if (locationEvent == null) {
            return false;
        }
        if (locationEvent.getType() == 3) {
            MessageManager.getInstance().unRegisterListener(this.f49390a);
            MessageManager.getInstance().registerListener(this.f49390a);
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
            d.a.n0.e3.m0.b.a().e(locationEvent.locationData);
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new ResponsedSelectLocation(locationEvent.isShowLocation, locationEvent.locName, locationEvent.locAddr, locationEvent.locSn));
        }
        return false;
    }
}
