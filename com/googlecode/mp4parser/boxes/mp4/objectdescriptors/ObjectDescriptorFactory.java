package com.googlecode.mp4parser.boxes.mp4.objectdescriptors;

import com.coremedia.iso.IsoTypeReader;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public class ObjectDescriptorFactory {
    public static Logger log = Logger.getLogger(ObjectDescriptorFactory.class.getName());
    public static Map<Integer, Map<Integer, Class<? extends BaseDescriptor>>> descriptorRegistry = new HashMap();

    static {
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
            for (int i : tags) {
                map.put(Integer.valueOf(i), cls);
            }
            descriptorRegistry.put(Integer.valueOf(objectTypeIndication), map);
        }
    }

    public static BaseDescriptor createFrom(int i, ByteBuffer byteBuffer) throws IOException {
        BaseDescriptor unknownDescriptor;
        int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
        Map<Integer, Class<? extends BaseDescriptor>> map = descriptorRegistry.get(Integer.valueOf(i));
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
                logger.log(level, "Couldn't instantiate BaseDescriptor class " + cls + " for objectTypeIndication " + i + " and tag " + readUInt8, (Throwable) e2);
                throw new RuntimeException(e2);
            }
        } else {
            Logger logger2 = log;
            logger2.warning("No ObjectDescriptor found for objectTypeIndication " + Integer.toHexString(i) + " and tag " + Integer.toHexString(readUInt8) + " found: " + cls);
            unknownDescriptor = new UnknownDescriptor();
        }
        unknownDescriptor.parse(readUInt8, byteBuffer);
        return unknownDescriptor;
    }
}
