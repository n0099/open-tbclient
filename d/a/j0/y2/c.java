package d.a.j0.y2;

import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.cloudcontrol.processor.DataProcessors;
import com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister;
import com.baidu.searchbox.pms.init.ApsCloudControlProcessor;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
@Singleton
@Service
/* loaded from: classes5.dex */
public class c implements ICloudControlRegister {
    @Override // com.baidu.searchbox.cloudcontrol.runtime.ICloudControlRegister
    public void registerAllProcessors(DataProcessors dataProcessors) {
        dataProcessors.addProcessor("aps", new ApsCloudControlProcessor());
        dataProcessors.addProcessor(UBCCloudControlProcessor.UBC_KEY, new UBCCloudControlProcessor());
    }
}
