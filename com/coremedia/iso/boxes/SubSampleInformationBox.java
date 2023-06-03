package com.coremedia.iso.boxes;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes9.dex */
public class SubSampleInformationBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "subs";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public List<SampleEntry> entries;
    public long entryCount;

    /* loaded from: classes9.dex */
    public static class SampleEntry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long sampleDelta;
        public int subsampleCount;
        public List<SubsampleEntry> subsampleEntries;

        /* loaded from: classes9.dex */
        public static class SubsampleEntry {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int discardable;
            public long reserved;
            public int subsamplePriority;
            public long subsampleSize;

            public SubsampleEntry() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public int getDiscardable() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.discardable;
                }
                return invokeV.intValue;
            }

            public long getReserved() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return this.reserved;
                }
                return invokeV.longValue;
            }

            public int getSubsamplePriority() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    return this.subsamplePriority;
                }
                return invokeV.intValue;
            }

            public long getSubsampleSize() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    return this.subsampleSize;
                }
                return invokeV.longValue;
            }

            public void setDiscardable(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                    this.discardable = i;
                }
            }

            public void setReserved(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
                    this.reserved = j;
                }
            }

            public void setSubsamplePriority(int i) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                    this.subsamplePriority = i;
                }
            }

            public void setSubsampleSize(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
                    this.subsampleSize = j;
                }
            }

            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                    return "SubsampleEntry{subsampleSize=" + this.subsampleSize + ", subsamplePriority=" + this.subsamplePriority + ", discardable=" + this.discardable + ", reserved=" + this.reserved + '}';
                }
                return (String) invokeV.objValue;
            }
        }

        public SampleEntry() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.subsampleEntries = new ArrayList();
        }

        public long getSampleDelta() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.sampleDelta;
            }
            return invokeV.longValue;
        }

        public int getSubsampleCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.subsampleCount;
            }
            return invokeV.intValue;
        }

        public List<SubsampleEntry> getSubsampleEntries() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.subsampleEntries;
            }
            return (List) invokeV.objValue;
        }

        public void addSubsampleEntry(SubsampleEntry subsampleEntry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, subsampleEntry) == null) {
                this.subsampleEntries.add(subsampleEntry);
                this.subsampleCount++;
            }
        }

        public void setSampleDelta(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.sampleDelta = j;
            }
        }

        public void setSubsampleCount(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                this.subsampleCount = i;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "SampleEntry{sampleDelta=" + this.sampleDelta + ", subsampleCount=" + this.subsampleCount + ", subsampleEntries=" + this.subsampleEntries + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1501387510, "Lcom/coremedia/iso/boxes/SubSampleInformationBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1501387510, "Lcom/coremedia/iso/boxes/SubSampleInformationBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    public List<SampleEntry> getEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.entries;
        }
        return (List) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubSampleInformationBox() {
        super(TYPE);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.entries = new ArrayList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            long j = (this.entryCount * 6) + 8;
            int i2 = 0;
            for (SampleEntry sampleEntry : this.entries) {
                int subsampleCount = sampleEntry.getSubsampleCount();
                if (getVersion() == 1) {
                    i = 4;
                } else {
                    i = 2;
                }
                i2 += subsampleCount * (i + 1 + 1 + 4);
            }
            return j + i2;
        }
        return invokeV.longValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return "SubSampleInformationBox{entryCount=" + this.entryCount + ", entries=" + this.entries + '}';
        }
        return (String) invokeV.objValue;
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("SubSampleInformationBox.java", SubSampleInformationBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.util.List"), 51);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setEntries", "com.coremedia.iso.boxes.SubSampleInformationBox", "java.util.List", "entries", "", "void"), 55);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "toString", "com.coremedia.iso.boxes.SubSampleInformationBox", "", "", "", "java.lang.String"), 115);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        long readUInt16;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            this.entryCount = IsoTypeReader.readUInt32(byteBuffer);
            for (int i = 0; i < this.entryCount; i++) {
                SampleEntry sampleEntry = new SampleEntry();
                sampleEntry.setSampleDelta(IsoTypeReader.readUInt32(byteBuffer));
                int readUInt162 = IsoTypeReader.readUInt16(byteBuffer);
                for (int i2 = 0; i2 < readUInt162; i2++) {
                    SampleEntry.SubsampleEntry subsampleEntry = new SampleEntry.SubsampleEntry();
                    if (getVersion() == 1) {
                        readUInt16 = IsoTypeReader.readUInt32(byteBuffer);
                    } else {
                        readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
                    }
                    subsampleEntry.setSubsampleSize(readUInt16);
                    subsampleEntry.setSubsamplePriority(IsoTypeReader.readUInt8(byteBuffer));
                    subsampleEntry.setDiscardable(IsoTypeReader.readUInt8(byteBuffer));
                    subsampleEntry.setReserved(IsoTypeReader.readUInt32(byteBuffer));
                    sampleEntry.addSubsampleEntry(subsampleEntry);
                }
                this.entries.add(sampleEntry);
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            IsoTypeWriter.writeUInt32(byteBuffer, this.entries.size());
            for (SampleEntry sampleEntry : this.entries) {
                IsoTypeWriter.writeUInt32(byteBuffer, sampleEntry.getSampleDelta());
                IsoTypeWriter.writeUInt16(byteBuffer, sampleEntry.getSubsampleCount());
                for (SampleEntry.SubsampleEntry subsampleEntry : sampleEntry.getSubsampleEntries()) {
                    if (getVersion() == 1) {
                        IsoTypeWriter.writeUInt32(byteBuffer, subsampleEntry.getSubsampleSize());
                    } else {
                        IsoTypeWriter.writeUInt16(byteBuffer, CastUtils.l2i(subsampleEntry.getSubsampleSize()));
                    }
                    IsoTypeWriter.writeUInt8(byteBuffer, subsampleEntry.getSubsamplePriority());
                    IsoTypeWriter.writeUInt8(byteBuffer, subsampleEntry.getDiscardable());
                    IsoTypeWriter.writeUInt32(byteBuffer, subsampleEntry.getReserved());
                }
            }
        }
    }

    public void setEntries(List<SampleEntry> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, list));
            this.entries = list;
            this.entryCount = list.size();
        }
    }
}
