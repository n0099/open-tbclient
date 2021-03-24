package com.googlecode.mp4parser.boxes.mp4.samplegrouping;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.googlecode.mp4parser.util.CastUtils;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class RateShareEntry extends GroupEntry {
    public static final String TYPE = "rash";
    public short discardPriority;
    public List<Entry> entries = new LinkedList();
    public int maximumBitrate;
    public int minimumBitrate;
    public short operationPointCut;
    public short targetRateShare;

    /* loaded from: classes6.dex */
    public static class Entry {
        public int availableBitrate;
        public short targetRateShare;

        public Entry(int i, short s) {
            this.availableBitrate = i;
            this.targetRateShare = s;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Entry.class != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.availableBitrate == entry.availableBitrate && this.targetRateShare == entry.targetRateShare;
        }

        public int getAvailableBitrate() {
            return this.availableBitrate;
        }

        public short getTargetRateShare() {
            return this.targetRateShare;
        }

        public int hashCode() {
            return (this.availableBitrate * 31) + this.targetRateShare;
        }

        public void setAvailableBitrate(int i) {
            this.availableBitrate = i;
        }

        public void setTargetRateShare(short s) {
            this.targetRateShare = s;
        }

        public String toString() {
            return "{availableBitrate=" + this.availableBitrate + ", targetRateShare=" + ((int) this.targetRateShare) + '}';
        }
    }

    public boolean equals(Object obj) {
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

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
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

    public short getDiscardPriority() {
        return this.discardPriority;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    public int getMaximumBitrate() {
        return this.maximumBitrate;
    }

    public int getMinimumBitrate() {
        return this.minimumBitrate;
    }

    public short getOperationPointCut() {
        return this.operationPointCut;
    }

    public short getTargetRateShare() {
        return this.targetRateShare;
    }

    public int hashCode() {
        int i = ((this.operationPointCut * 31) + this.targetRateShare) * 31;
        List<Entry> list = this.entries;
        return ((((((i + (list != null ? list.hashCode() : 0)) * 31) + this.maximumBitrate) * 31) + this.minimumBitrate) * 31) + this.discardPriority;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
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

    public void setDiscardPriority(short s) {
        this.discardPriority = s;
    }

    public void setEntries(List<Entry> list) {
        this.entries = list;
    }

    public void setMaximumBitrate(int i) {
        this.maximumBitrate = i;
    }

    public void setMinimumBitrate(int i) {
        this.minimumBitrate = i;
    }

    public void setOperationPointCut(short s) {
        this.operationPointCut = s;
    }

    public void setTargetRateShare(short s) {
        this.targetRateShare = s;
    }
}
