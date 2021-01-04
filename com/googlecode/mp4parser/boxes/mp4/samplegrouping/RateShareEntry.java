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
    private short discardPriority;
    private List<Entry> entries = new LinkedList();
    private int maximumBitrate;
    private int minimumBitrate;
    private short operationPointCut;
    private short targetRateShare;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public void parse(ByteBuffer byteBuffer) {
        this.operationPointCut = byteBuffer.getShort();
        if (this.operationPointCut == 1) {
            this.targetRateShare = byteBuffer.getShort();
        } else {
            short s = this.operationPointCut;
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

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry
    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(this.operationPointCut == 1 ? 13 : (this.operationPointCut * 6) + 11);
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

    /* loaded from: classes6.dex */
    public static class Entry {
        int availableBitrate;
        short targetRateShare;

        public Entry(int i, short s) {
            this.availableBitrate = i;
            this.targetRateShare = s;
        }

        public String toString() {
            return "{availableBitrate=" + this.availableBitrate + ", targetRateShare=" + ((int) this.targetRateShare) + '}';
        }

        public int getAvailableBitrate() {
            return this.availableBitrate;
        }

        public void setAvailableBitrate(int i) {
            this.availableBitrate = i;
        }

        public short getTargetRateShare() {
            return this.targetRateShare;
        }

        public void setTargetRateShare(short s) {
            this.targetRateShare = s;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Entry entry = (Entry) obj;
            return this.availableBitrate == entry.availableBitrate && this.targetRateShare == entry.targetRateShare;
        }

        public int hashCode() {
            return (this.availableBitrate * 31) + this.targetRateShare;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RateShareEntry rateShareEntry = (RateShareEntry) obj;
        if (this.discardPriority == rateShareEntry.discardPriority && this.maximumBitrate == rateShareEntry.maximumBitrate && this.minimumBitrate == rateShareEntry.minimumBitrate && this.operationPointCut == rateShareEntry.operationPointCut && this.targetRateShare == rateShareEntry.targetRateShare) {
            if (this.entries != null) {
                if (this.entries.equals(rateShareEntry.entries)) {
                    return true;
                }
            } else if (rateShareEntry.entries == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.entries != null ? this.entries.hashCode() : 0) + (((this.operationPointCut * 31) + this.targetRateShare) * 31)) * 31) + this.maximumBitrate) * 31) + this.minimumBitrate) * 31) + this.discardPriority;
    }

    public short getOperationPointCut() {
        return this.operationPointCut;
    }

    public void setOperationPointCut(short s) {
        this.operationPointCut = s;
    }

    public short getTargetRateShare() {
        return this.targetRateShare;
    }

    public void setTargetRateShare(short s) {
        this.targetRateShare = s;
    }

    public List<Entry> getEntries() {
        return this.entries;
    }

    public void setEntries(List<Entry> list) {
        this.entries = list;
    }

    public int getMaximumBitrate() {
        return this.maximumBitrate;
    }

    public void setMaximumBitrate(int i) {
        this.maximumBitrate = i;
    }

    public int getMinimumBitrate() {
        return this.minimumBitrate;
    }

    public void setMinimumBitrate(int i) {
        this.minimumBitrate = i;
    }

    public short getDiscardPriority() {
        return this.discardPriority;
    }

    public void setDiscardPriority(short s) {
        this.discardPriority = s;
    }
}
