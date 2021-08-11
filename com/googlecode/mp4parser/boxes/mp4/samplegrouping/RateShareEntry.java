package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class RateShareEntry extends GroupEntry {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "rash";
    public transient /* synthetic */ FieldHolder $fh;
    public short discardPriority;
    public List<Entry> entries;
    public int maximumBitrate;
    public int minimumBitrate;
    public short operationPointCut;
    public short targetRateShare;

    /* loaded from: classes10.dex */
    public static class Entry {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int availableBitrate;
        public short targetRateShare;

        public Entry(int i2, short s) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Short.valueOf(s)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.availableBitrate = i2;
            this.targetRateShare = s;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Entry.class != obj.getClass()) {
                    return false;
                }
                Entry entry = (Entry) obj;
                return this.availableBitrate == entry.availableBitrate && this.targetRateShare == entry.targetRateShare;
            }
            return invokeL.booleanValue;
        }

        public int getAvailableBitrate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.availableBitrate : invokeV.intValue;
        }

        public short getTargetRateShare() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.targetRateShare : invokeV.shortValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.availableBitrate * 31) + this.targetRateShare : invokeV.intValue;
        }

        public void setAvailableBitrate(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
                this.availableBitrate = i2;
            }
        }

        public void setTargetRateShare(short s) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Short.valueOf(s)}) == null) {
                this.targetRateShare = s;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return "{availableBitrate=" + this.availableBitrate + ", targetRateShare=" + ((int) this.targetRateShare) + ExtendedMessageFormat.END_FE;
            }
            return (String) invokeV.objValue;
        }
    }

    public RateShareEntry() {
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
        this.entries = new LinkedList();
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || RateShareEntry.class != obj.getClass()) {
                return false;
            }
            RateShareEntry rateShareEntry = (RateShareEntry) obj;
            if (this.discardPriority == rateShareEntry.discardPriority && this.maximumBitrate == rateShareEntry.maximumBitrate && this.minimumBitrate == rateShareEntry.minimumBitrate && this.operationPointCut == rateShareEntry.operationPointCut && this.targetRateShare == rateShareEntry.targetRateShare) {
                List<Entry> list = this.entries;
                List<Entry> list2 = rateShareEntry.entries;
                return list == null ? list2 == null : list.equals(list2);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            short s = this.operationPointCut;
            ByteBuffer allocate = ByteBuffer.allocate(s == 1 ? 13 : (s * 6) + 11);
            allocate.putShort(this.operationPointCut);
            if (this.operationPointCut == 1) {
                allocate.putShort(this.targetRateShare);
            } else {
                for (Entry entry : this.entries) {
                    allocate.putInt(entry.getAvailableBitrate());
                    allocate.putShort(entry.getTargetRateShare());
                }
            }
            allocate.putInt(this.maximumBitrate);
            allocate.putInt(this.minimumBitrate);
            IsoTypeWriter.writeUInt8(allocate, this.discardPriority);
            allocate.rewind();
            return allocate;
        }
        return (ByteBuffer) invokeV.objValue;
    }

    public short getDiscardPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.discardPriority : invokeV.shortValue;
    }

    public List<Entry> getEntries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.entries : (List) invokeV.objValue;
    }

    public int getMaximumBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.maximumBitrate : invokeV.intValue;
    }

    public int getMinimumBitrate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.minimumBitrate : invokeV.intValue;
    }

    public short getOperationPointCut() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.operationPointCut : invokeV.shortValue;
    }

    public short getTargetRateShare() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.targetRateShare : invokeV.shortValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = ((this.operationPointCut * 31) + this.targetRateShare) * 31;
            List<Entry> list = this.entries;
            return ((((((i2 + (list != null ? list.hashCode() : 0)) * 31) + this.maximumBitrate) * 31) + this.minimumBitrate) * 31) + this.discardPriority;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, byteBuffer) == null) {
            short s = byteBuffer.getShort();
            this.operationPointCut = s;
            if (s == 1) {
                this.targetRateShare = byteBuffer.getShort();
            } else {
                while (true) {
                    ?? r1 = s - 1;
                    if (s <= 0) {
                        break;
                    }
                    this.entries.add(new Entry(CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer)), byteBuffer.getShort()));
                    s = r1;
                }
            }
            this.maximumBitrate = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            this.minimumBitrate = CastUtils.l2i(IsoTypeReader.readUInt32(byteBuffer));
            this.discardPriority = (short) IsoTypeReader.readUInt8(byteBuffer);
        }
    }

    public void setDiscardPriority(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Short.valueOf(s)}) == null) {
            this.discardPriority = s;
        }
    }

    public void setEntries(List<Entry> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, list) == null) {
            this.entries = list;
        }
    }

    public void setMaximumBitrate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.maximumBitrate = i2;
        }
    }

    public void setMinimumBitrate(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.minimumBitrate = i2;
        }
    }

    public void setOperationPointCut(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Short.valueOf(s)}) == null) {
            this.operationPointCut = s;
        }
    }

    public void setTargetRateShare(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Short.valueOf(s)}) == null) {
            this.targetRateShare = s;
        }
    }
}
