package com.googlecode.mp4parser;

import com.coremedia.iso.BoxParser;
import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.Container;
import com.googlecode.mp4parser.util.LazyList;
import com.googlecode.mp4parser.util.Logger;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public class BasicContainer implements Container, Iterator<Box> {
    public BoxParser boxParser;
    public DataSource dataSource;
    public static Logger LOG = Logger.getLogger(AbstractContainerBox.class);
    public static final Box EOF = new a("eof ");
    public List<Box> boxes = new ArrayList();
    public Box lookahead = null;
    public long parsePosition = 0;
    public long startPosition = 0;
    public long endPosition = 0;

    /* loaded from: classes6.dex */
    public class a extends AbstractBox {
        public a(String str) {
            super(str);
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        public void _parseDetails(ByteBuffer byteBuffer) {
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        public void getContent(ByteBuffer byteBuffer) {
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        public long getContentSize() {
            return 0L;
        }
    }

    public void addBox(Box box) {
        this.boxes = new ArrayList(getBoxes());
        box.setParent(this);
        this.boxes.add(box);
    }

    @Override // com.coremedia.iso.boxes.Container
    public List<Box> getBoxes() {
        if (this.dataSource != null && this.lookahead != EOF) {
            return new LazyList(this.boxes, this);
        }
        return this.boxes;
    }

    @Override // com.coremedia.iso.boxes.Container
    public ByteBuffer getByteBuffer(long j, long j2) throws IOException {
        ByteBuffer map;
        synchronized (this.dataSource) {
            map = this.dataSource.map(this.startPosition + j, j2);
        }
        return map;
    }

    public long getContainerSize() {
        long j = 0;
        for (int i2 = 0; i2 < getBoxes().size(); i2++) {
            j += this.boxes.get(i2).getSize();
        }
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Box box = this.lookahead;
        if (box == EOF) {
            return false;
        }
        if (box != null) {
            return true;
        }
        try {
            this.lookahead = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.lookahead = EOF;
            return false;
        }
    }

    public void parseContainer(DataSource dataSource, long j, BoxParser boxParser) throws IOException {
        this.dataSource = dataSource;
        long position = dataSource.position();
        this.startPosition = position;
        this.parsePosition = position;
        dataSource.position(dataSource.position() + j);
        this.endPosition = dataSource.position();
        this.boxParser = boxParser;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        this.boxes = new ArrayList(list);
        this.lookahead = EOF;
        this.dataSource = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            if (i2 > 0) {
                sb.append(";");
            }
            sb.append(this.boxes.get(i2).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // com.coremedia.iso.boxes.Container
    public final void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        for (Box box : getBoxes()) {
            box.getBox(writableByteChannel);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Box next() {
        Box parseBox;
        Box box = this.lookahead;
        if (box != null && box != EOF) {
            this.lookahead = null;
            return box;
        }
        LOG.logDebug("Parsing next() box");
        DataSource dataSource = this.dataSource;
        if (dataSource != null && this.parsePosition < this.endPosition) {
            try {
                synchronized (dataSource) {
                    this.dataSource.position(this.parsePosition);
                    parseBox = this.boxParser.parseBox(this.dataSource, this);
                    this.parsePosition = this.dataSource.position();
                }
                return parseBox;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        }
        this.lookahead = EOF;
        throw new NoSuchElementException();
    }

    @Override // com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls) {
        return getBoxes(cls, false);
    }

    @Override // com.coremedia.iso.boxes.Container
    public <T extends Box> List<T> getBoxes(Class<T> cls, boolean z) {
        ArrayList arrayList = new ArrayList(2);
        for (Box box : getBoxes()) {
            if (cls.isInstance(box)) {
                arrayList.add(box);
            }
            if (z && (box instanceof Container)) {
                arrayList.addAll(((Container) box).getBoxes(cls, z));
            }
        }
        return arrayList;
    }
}
