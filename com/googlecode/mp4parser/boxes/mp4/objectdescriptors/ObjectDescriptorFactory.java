package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes3.dex */
public class ObjectDescriptorFactory {
    public static /* synthetic */ Interceptable $ic;
    public static Map<Integer, Map<Integer, Class<? extends BaseDescriptor>>> descriptorRegistry;
    public static Logger log;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1589297077, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/ObjectDescriptorFactory;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1589297077, "Lcom/googlecode/mp4parser/boxes/mp4/objectdescriptors/ObjectDescriptorFactory;");
                return;
            }
        }
        log = Logger.getLogger(ObjectDescriptorFactory.class.getName());
        descriptorRegistry = new HashMap();
        HashSet<Class<? extends BaseDescriptor>> hashSet = new HashSet();
        hashSet.add(DecoderSpecificInfo.class);
        hashSet.add(SLConfigDescriptor.class);
        hashSet.add(BaseDescriptor.class);
        hashSet.add(ExtensionDescriptor.class);
        hashSet.add(ObjectDescriptorBase.class);
        hashSet.add(ProfileLevelIndicationDescriptor.class);
        hashSet.add(AudioSpecificConfig.class);
        hashSet.add(ExtensionProfileLevelDescriptor.class);
        hashSet.add(ESDescriptor.class);
        hashSet.add(DecoderConfigDescriptor.class);
        for (Class<? extends BaseDescriptor> cls : hashSet) {
            Descriptor descriptor = (Descriptor) cls.getAnnotation(Descriptor.class);
            int[] tags = descriptor.tags();
            int objectTypeIndication = descriptor.objectTypeIndication();
            Map<Integer, Class<? extends BaseDescriptor>> map = descriptorRegistry.get(Integer.valueOf(objectTypeIndication));
            if (map == null) {
                map = new HashMap<>();
            }
            for (int i2 : tags) {
                map.put(Integer.valueOf(i2), cls);
            }
            descriptorRegistry.put(Integer.valueOf(objectTypeIndication), map);
        }
    }

    public ObjectDescriptorFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static BaseDescriptor createFrom(int i2, ByteBuffer byteBuffer) throws IOException {
        InterceptResult invokeIL;
        BaseDescriptor unknownDescriptor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, byteBuffer)) == null) {
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            Map<Integer, Class<? extends BaseDescriptor>> map = descriptorRegistry.get(Integer.valueOf(i2));
            if (map == null) {
                map = descriptorRegistry.get(-1);
            }
            Class<? extends BaseDescriptor> cls = map.get(Integer.valueOf(readUInt8));
            if (cls != null && !cls.isInterface() && !Modifier.isAbstract(cls.getModifiers())) {
                try {
                    unknownDescriptor = cls.newInstance();
                } catch (Exception e2) {
                    Logger logger = log;
                    Level level = Level.SEVERE;
                    logger.log(level, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i2 + " and tag " + readUInt8, (Throwable) e2);
                    throw new RuntimeException(e2);
                }
            } else {
                Logger logger2 = log;
                logger2.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i2) + " and tag " + Integer.toHexString(readUInt8) + " found: " + cls);
                unknownDescriptor = new UnknownDescriptor();
            }
            unknownDescriptor.parse(readUInt8, byteBuffer);
            return unknownDescriptor;
        }
        return (BaseDescriptor) invokeIL.objValue;
    }
}
