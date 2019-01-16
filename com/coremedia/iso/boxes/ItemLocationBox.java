package com.coremedia.iso.boxes;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeReaderVariable;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.IsoTypeWriterVariable;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.RequiresParseDetailAspect;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.aspectj.a.b.b;
import org.aspectj.lang.a;
/* loaded from: classes5.dex */
public class ItemLocationBox extends AbstractFullBox {
    public static final String TYPE = "iloc";
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_0 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_1 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_10 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_11 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_2 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_3 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_4 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_5 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_6 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_7 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_8 = null;
    private static final /* synthetic */ a.InterfaceC0401a ajc$tjp_9 = null;
    public int baseOffsetSize;
    public int indexSize;
    public List<Item> items;
    public int lengthSize;
    public int offsetSize;

    static {
        ajc$preClinit();
    }

    private static /* synthetic */ void ajc$preClinit() {
        b bVar = new b("ItemLocationBox.java", ItemLocationBox.class);
        ajc$tjp_0 = bVar.a("method-execution", bVar.b("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ajc$tjp_1 = bVar.a("method-execution", bVar.b("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ajc$tjp_10 = bVar.a("method-execution", bVar.b("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ajc$tjp_11 = bVar.a("method-execution", bVar.b("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        ajc$tjp_2 = bVar.a("method-execution", bVar.b("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ajc$tjp_3 = bVar.a("method-execution", bVar.b("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ajc$tjp_4 = bVar.a("method-execution", bVar.b("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ajc$tjp_5 = bVar.a("method-execution", bVar.b("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 139);
        ajc$tjp_6 = bVar.a("method-execution", bVar.b("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        ajc$tjp_7 = bVar.a("method-execution", bVar.b("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ajc$tjp_8 = bVar.a("method-execution", bVar.b("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        ajc$tjp_9 = bVar.a("method-execution", bVar.b("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    public ItemLocationBox() {
        super(TYPE);
        this.offsetSize = 8;
        this.lengthSize = 8;
        this.baseOffsetSize = 8;
        this.indexSize = 0;
        this.items = new LinkedList();
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        long j = 8;
        Iterator<Item> it = this.items.iterator();
        while (true) {
            long j2 = j;
            if (it.hasNext()) {
                j = it.next().getSize() + j2;
            } else {
                return j2;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
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

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
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
            this.items.add(new Item(byteBuffer));
        }
    }

    public int getOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_0, this, this));
        return this.offsetSize;
    }

    public void setOffsetSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_1, this, this, org.aspectj.a.a.a.zt(i)));
        this.offsetSize = i;
    }

    public int getLengthSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_2, this, this));
        return this.lengthSize;
    }

    public void setLengthSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_3, this, this, org.aspectj.a.a.a.zt(i)));
        this.lengthSize = i;
    }

    public int getBaseOffsetSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_4, this, this));
        return this.baseOffsetSize;
    }

    public void setBaseOffsetSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_5, this, this, org.aspectj.a.a.a.zt(i)));
        this.baseOffsetSize = i;
    }

    public int getIndexSize() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_6, this, this));
        return this.indexSize;
    }

    public void setIndexSize(int i) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_7, this, this, org.aspectj.a.a.a.zt(i)));
        this.indexSize = i;
    }

    public List<Item> getItems() {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_8, this, this));
        return this.items;
    }

    public void setItems(List<Item> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_9, this, this, list));
        this.items = list;
    }

    public Item createItem(int i, int i2, int i3, long j, List<Extent> list) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_10, (Object) this, (Object) this, new Object[]{org.aspectj.a.a.a.zt(i), org.aspectj.a.a.a.zt(i2), org.aspectj.a.a.a.zt(i3), org.aspectj.a.a.a.dE(j), list}));
        return new Item(i, i2, i3, j, list);
    }

    Item createItem(ByteBuffer byteBuffer) {
        return new Item(byteBuffer);
    }

    /* loaded from: classes5.dex */
    public class Item {
        public long baseOffset;
        public int constructionMethod;
        public int dataReferenceIndex;
        public List<Extent> extents;
        public int itemId;

        public Item(ByteBuffer byteBuffer) {
            this.extents = new LinkedList();
            this.itemId = IsoTypeReader.readUInt16(byteBuffer);
            if (ItemLocationBox.this.getVersion() == 1) {
                this.constructionMethod = IsoTypeReader.readUInt16(byteBuffer) & 15;
            }
            this.dataReferenceIndex = IsoTypeReader.readUInt16(byteBuffer);
            if (ItemLocationBox.this.baseOffsetSize > 0) {
                this.baseOffset = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.baseOffsetSize);
            } else {
                this.baseOffset = 0L;
            }
            int readUInt16 = IsoTypeReader.readUInt16(byteBuffer);
            for (int i = 0; i < readUInt16; i++) {
                this.extents.add(new Extent(byteBuffer));
            }
        }

        public Item(int i, int i2, int i3, long j, List<Extent> list) {
            this.extents = new LinkedList();
            this.itemId = i;
            this.constructionMethod = i2;
            this.dataReferenceIndex = i3;
            this.baseOffset = j;
            this.extents = list;
        }

        public int getSize() {
            int i = 2;
            if (ItemLocationBox.this.getVersion() == 1) {
                i = 4;
            }
            int i2 = i + 2 + ItemLocationBox.this.baseOffsetSize + 2;
            Iterator<Extent> it = this.extents.iterator();
            while (true) {
                int i3 = i2;
                if (it.hasNext()) {
                    i2 = it.next().getSize() + i3;
                } else {
                    return i3;
                }
            }
        }

        public void setBaseOffset(long j) {
            this.baseOffset = j;
        }

        public void getContent(ByteBuffer byteBuffer) {
            IsoTypeWriter.writeUInt16(byteBuffer, this.itemId);
            if (ItemLocationBox.this.getVersion() == 1) {
                IsoTypeWriter.writeUInt16(byteBuffer, this.constructionMethod);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.dataReferenceIndex);
            if (ItemLocationBox.this.baseOffsetSize > 0) {
                IsoTypeWriterVariable.write(this.baseOffset, byteBuffer, ItemLocationBox.this.baseOffsetSize);
            }
            IsoTypeWriter.writeUInt16(byteBuffer, this.extents.size());
            for (Extent extent : this.extents) {
                extent.getContent(byteBuffer);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Item item = (Item) obj;
            if (this.baseOffset == item.baseOffset && this.constructionMethod == item.constructionMethod && this.dataReferenceIndex == item.dataReferenceIndex && this.itemId == item.itemId) {
                if (this.extents != null) {
                    if (this.extents.equals(item.extents)) {
                        return true;
                    }
                } else if (item.extents == null) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (this.extents != null ? this.extents.hashCode() : 0) + (((((((this.itemId * 31) + this.constructionMethod) * 31) + this.dataReferenceIndex) * 31) + ((int) (this.baseOffset ^ (this.baseOffset >>> 32)))) * 31);
        }

        public String toString() {
            return "Item{baseOffset=" + this.baseOffset + ", itemId=" + this.itemId + ", constructionMethod=" + this.constructionMethod + ", dataReferenceIndex=" + this.dataReferenceIndex + ", extents=" + this.extents + '}';
        }
    }

    public Extent createExtent(long j, long j2, long j3) {
        RequiresParseDetailAspect.aspectOf().before(b.a(ajc$tjp_11, (Object) this, (Object) this, new Object[]{org.aspectj.a.a.a.dE(j), org.aspectj.a.a.a.dE(j2), org.aspectj.a.a.a.dE(j3)}));
        return new Extent(j, j2, j3);
    }

    Extent createExtent(ByteBuffer byteBuffer) {
        return new Extent(byteBuffer);
    }

    /* loaded from: classes5.dex */
    public class Extent {
        public long extentIndex;
        public long extentLength;
        public long extentOffset;

        public Extent(long j, long j2, long j3) {
            this.extentOffset = j;
            this.extentLength = j2;
            this.extentIndex = j3;
        }

        public Extent(ByteBuffer byteBuffer) {
            if (ItemLocationBox.this.getVersion() == 1 && ItemLocationBox.this.indexSize > 0) {
                this.extentIndex = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.indexSize);
            }
            this.extentOffset = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.offsetSize);
            this.extentLength = IsoTypeReaderVariable.read(byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public void getContent(ByteBuffer byteBuffer) {
            if (ItemLocationBox.this.getVersion() == 1 && ItemLocationBox.this.indexSize > 0) {
                IsoTypeWriterVariable.write(this.extentIndex, byteBuffer, ItemLocationBox.this.indexSize);
            }
            IsoTypeWriterVariable.write(this.extentOffset, byteBuffer, ItemLocationBox.this.offsetSize);
            IsoTypeWriterVariable.write(this.extentLength, byteBuffer, ItemLocationBox.this.lengthSize);
        }

        public int getSize() {
            return (ItemLocationBox.this.indexSize > 0 ? ItemLocationBox.this.indexSize : 0) + ItemLocationBox.this.offsetSize + ItemLocationBox.this.lengthSize;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Extent extent = (Extent) obj;
            return this.extentIndex == extent.extentIndex && this.extentLength == extent.extentLength && this.extentOffset == extent.extentOffset;
        }

        public int hashCode() {
            return (((((int) (this.extentOffset ^ (this.extentOffset >>> 32))) * 31) + ((int) (this.extentLength ^ (this.extentLength >>> 32)))) * 31) + ((int) (this.extentIndex ^ (this.extentIndex >>> 32)));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Extent");
            sb.append("{extentOffset=").append(this.extentOffset);
            sb.append(", extentLength=").append(this.extentLength);
            sb.append(", extentIndex=").append(this.extentIndex);
            sb.append('}');
            return sb.toString();
        }
    }
}
