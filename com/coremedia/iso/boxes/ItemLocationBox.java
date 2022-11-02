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
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.Conversions;
import org.aspectj.runtime.reflect.Factory;
/* loaded from: classes7.dex */
public class ItemLocationBox extends AbstractFullBox {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TYPE = "iloc";
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_10 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_11 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_3 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_4 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_5 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_6 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_7 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_8 = null;
    public static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_9 = null;
    public transient /* synthetic */ FieldHolder $fh;
    public int baseOffsetSize;
    public int indexSize;
    public List<Item> items;
    public int lengthSize;
    public int offsetSize;

    /* loaded from: classes7.dex */
    public class Extent {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long extentIndex;
        public long extentLength;
        public long extentOffset;
        public final /* synthetic */ ItemLocationBox this$0;

        public Extent(ItemLocationBox itemLocationBox, long j, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemLocationBox, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = itemLocationBox;
            this.extentOffset = j;
            this.extentLength = j2;
            this.extentIndex = j3;
        }

        public Extent(ItemLocationBox itemLocationBox, ByteBuffer byteBuffer) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemLocationBox, byteBuffer};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = itemLocationBox;
            if (itemLocationBox.getVersion() == 1 && (i = itemLocationBox.indexSize) > 0) {
                this.extentIndex = IsoTypeReaderVariable.read(byteBuffer, i);
            }
            this.extentOffset = IsoTypeReaderVariable.read(byteBuffer, itemLocationBox.offsetSize);
            this.extentLength = IsoTypeReaderVariable.read(byteBuffer, itemLocationBox.lengthSize);
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Extent.class != obj.getClass()) {
                    return false;
                }
                Extent extent = (Extent) obj;
                if (this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void getContent(ByteBuffer byteBuffer) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                if (this.this$0.getVersion() == 1 && (i = this.this$0.indexSize) > 0) {
                    IsoTypeWriterVariable.write(this.extentIndex, byteBuffer, i);
                }
                IsoTypeWriterVariable.write(this.extentOffset, byteBuffer, this.this$0.offsetSize);
                IsoTypeWriterVariable.write(this.extentLength, byteBuffer, this.this$0.lengthSize);
            }
        }

        public int getSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                int i = this.this$0.indexSize;
                if (i <= 0) {
                    i = 0;
                }
                ItemLocationBox itemLocationBox = this.this$0;
                return i + itemLocationBox.offsetSize + itemLocationBox.lengthSize;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                long j = this.extentOffset;
                long j2 = this.extentLength;
                long j3 = this.extentIndex;
                return (((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Extent{extentOffset=" + this.extentOffset + ", extentLength=" + this.extentLength + ", extentIndex=" + this.extentIndex + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class Item {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents;
        public int itemId;
        public final /* synthetic */ ItemLocationBox this$0;

        public Item(ItemLocationBox itemLocationBox, int i, int i2, int i3, long j, List<Extent> list) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemLocationBox, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = itemLocationBox;
            this.extents = new LinkedList();
            this.itemId = i;
            this.constructionMethod = i2;
            this.dataReferenceIndex = i3;
            this.baseOffset = j;
            this.extents = list;
        }

        public Item(ItemLocationBox itemLocationBox, ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {itemLocationBox, byteBuffer};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.this$0 = itemLocationBox;
            this.extents = new LinkedList();
            this.itemId = IsoTypeReader.readUInt16(byteBuffer);
            if (itemLocationBox.getVersion() == 1) {
                this.constructionMethod = IsoTypeReader.readUInt16(byteBuffer) & 15;
            }
            this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
            int i3 = itemLocationBox.baseOffsetSize;
            if (i3 > 0) {
                this.baseOffset = IsoTypeReaderVariable.read(byteBuffer, i3);
            } else {
                this.baseOffset = 0L;
            }
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i4 = 0; i4 < readUInt16; i4++) {
                this.extents.add(new Extent(itemLocationBox, byteBuffer));
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Item.class != obj.getClass()) {
                    return false;
                }
                Item item = (Item) obj;
                if (this.baseOffset != item.baseOffset || this.constructionMethod != item.constructionMethod || this.dataReferenceIndex != item.dataReferenceIndex || this.itemId != item.itemId) {
                    return false;
                }
                List<Extent> list = this.extents;
                List<Extent> list2 = item.extents;
                if (list == null ? list2 == null : list.equals(list2)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public void getContent(ByteBuffer byteBuffer) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.itemId);
                if (this.this$0.getVersion() == 1) {
                    IsoTypeWriter.writeUInt16(byteBuffer, this.constructionMethod);
                }
                IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
                int i = this.this$0.baseOffsetSize;
                if (i > 0) {
                    IsoTypeWriterVariable.write(this.baseOffset, byteBuffer, i);
                }
                IsoTypeWriter.writeUInt16(byteBuffer, this.extents.size());
                for (Extent extent : this.extents) {
                    extent.getContent(byteBuffer);
                }
            }
        }

        public int getSize() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.this$0.getVersion() == 1) {
                    i = 4;
                } else {
                    i = 2;
                }
                int i2 = i + 2 + this.this$0.baseOffsetSize + 2;
                for (Extent extent : this.extents) {
                    i2 += extent.getSize();
                }
                return i2;
            }
            return invokeV.intValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                long j = this.baseOffset;
                int i2 = ((((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
                List<Extent> list = this.extents;
                if (list != null) {
                    i = list.hashCode();
                } else {
                    i = 0;
                }
                return i2 + i;
            }
            return invokeV.intValue;
        }

        public void setBaseOffset(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
                this.baseOffset = j;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return "Item{baseOffset=" + this.baseOffset + ", itemId=" + this.itemId + ", constructionMethod=" + this.constructionMethod + ", dataReferenceIndex=" + this.dataReferenceIndex + ", extents=" + this.extents + '}';
            }
            return (String) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-781159140, "Lcom/coremedia/iso/boxes/ItemLocationBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-781159140, "Lcom/coremedia/iso/boxes/ItemLocationBox;");
                return;
            }
        }
        ajc$preClinit();
    }

    public int getBaseOffsetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_4, this, this));
            return this.baseOffsetSize;
        }
        return invokeV.intValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public long getContentSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            long j = 8;
            for (Item item : this.items) {
                j += item.getSize();
            }
            return j;
        }
        return invokeV.longValue;
    }

    public int getIndexSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_6, this, this));
            return this.indexSize;
        }
        return invokeV.intValue;
    }

    public List<Item> getItems() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_8, this, this));
            return this.items;
        }
        return (List) invokeV.objValue;
    }

    public int getLengthSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_2, this, this));
            return this.lengthSize;
        }
        return invokeV.intValue;
    }

    public int getOffsetSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_0, this, this));
            return this.offsetSize;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemLocationBox() {
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
        this.offsetSize = 8;
        this.lengthSize = 8;
        this.baseOffsetSize = 8;
        this.indexSize = 0;
        this.items = new LinkedList();
    }

    public static /* synthetic */ void ajc$preClinit() {
        Factory factory = new Factory("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ajc$tjp_1 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ajc$tjp_10 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ajc$tjp_11 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        ajc$tjp_2 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ajc$tjp_3 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ajc$tjp_4 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ajc$tjp_5 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), Cea708Decoder.COMMAND_TGW);
        ajc$tjp_6 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), Cea708Decoder.COMMAND_RST);
        ajc$tjp_7 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ajc$tjp_8 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), Cea708Decoder.COMMAND_SWA);
        ajc$tjp_9 = factory.makeSJP(JoinPoint.METHOD_EXECUTION, factory.makeMethodSig("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, byteBuffer) == null) {
            parseVersionAndFlags(byteBuffer);
            int readUInt8 = IsoTypeReader.readUInt8(byteBuffer);
            this.offsetSize = readUInt8 >>> 4;
            this.lengthSize = readUInt8 & 15;
            int readUInt82 = IsoTypeReader.readUInt8(byteBuffer);
            this.baseOffsetSize = readUInt82 >>> 4;
            if (getVersion() == 1) {
                this.indexSize = readUInt82 & 15;
            }
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i = 0; i < readUInt16; i++) {
                this.items.add(new Item(this, byteBuffer));
            }
        }
    }

    public Extent createExtent(long j, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_11, (Object) this, (Object) this, new Object[]{Conversions.longObject(j), Conversions.longObject(j2), Conversions.longObject(j3)}));
            return new Extent(this, j, j2, j3);
        }
        return (Extent) invokeCommon.objValue;
    }

    public Extent createExtent(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer)) == null) {
            return new Extent(this, byteBuffer);
        }
        return (Extent) invokeL.objValue;
    }

    public Item createItem(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteBuffer)) == null) {
            return new Item(this, byteBuffer);
        }
        return (Item) invokeL.objValue;
    }

    public void setBaseOffsetSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_5, this, this, Conversions.intObject(i)));
            this.baseOffsetSize = i;
        }
    }

    public void setIndexSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_7, this, this, Conversions.intObject(i)));
            this.indexSize = i;
        }
    }

    public void setItems(List<Item> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, list) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_9, this, this, list));
            this.items = list;
        }
    }

    public void setLengthSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_3, this, this, Conversions.intObject(i)));
            this.lengthSize = i;
        }
    }

    public void setOffsetSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_1, this, this, Conversions.intObject(i)));
            this.offsetSize = i;
        }
    }

    public Item createItem(int i, int i2, int i3, long j, List<Extent> list) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), list})) == null) {
            RequiresParseDetailAspect.aspectOf().before(Factory.makeJP(ajc$tjp_10, (Object) this, (Object) this, new Object[]{Conversions.intObject(i), Conversions.intObject(i2), Conversions.intObject(i3), Conversions.longObject(j), list}));
            return new Item(this, i, i2, i3, j, list);
        }
        return (Item) invokeCommon.objValue;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void getContent(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, byteBuffer) == null) {
            writeVersionAndFlags(byteBuffer);
            IsoTypeWriter.writeUInt8(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
            if (getVersion() == 1) {
                IsoTypeWriter.writeUInt8(byteBuffer, (this.baseOffsetSize << 4) | this.indexSize);
            } else {
                IsoTypeWriter.writeUInt8(byteBuffer, this.baseOffsetSize << 4);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.items.size());
            for (Item item : this.items) {
                item.getContent(byteBuffer);
            }
        }
    }
}
