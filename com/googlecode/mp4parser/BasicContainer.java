package com.googlecode.mp4parser;

import com.baidu.adp.plugin.proxy.ContentProviderProxy;
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
/* loaded from: classes2.dex */
public class BasicContainer implements Container, Iterator<Box> {
    protected BoxParser boxParser;
    protected DataSource dataSource;
    private static Logger LOG = Logger.getLogger(AbstractContainerBox.class);
    private static final Box EOF = new AbstractBox("eof ") { // from class: com.googlecode.mp4parser.BasicContainer.1
        @Override // com.googlecode.mp4parser.AbstractBox
        protected long getContentSize() {
            return 0L;
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        protected void getContent(ByteBuffer byteBuffer) {
        }

        @Override // com.googlecode.mp4parser.AbstractBox
        protected void _parseDetails(ByteBuffer byteBuffer) {
        }
    };
    private List<Box> boxes = new ArrayList();
    Box lookahead = null;
    long parsePosition = 0;
    long startPosition = 0;
    long endPosition = 0;

    @Override // com.coremedia.iso.boxes.Container
    public List<Box> getBoxes() {
        return (this.dataSource == null || this.lookahead == EOF) ? this.boxes : new LazyList(this.boxes, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getContainerSize() {
        long j = 0;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getBoxes().size()) {
                j += this.boxes.get(i2).getSize();
                i = i2 + 1;
            } else {
                return j;
            }
        }
    }

    @Override // com.coremedia.iso.boxes.Container
    public void setBoxes(List<Box> list) {
        this.boxes = new ArrayList(list);
        this.lookahead = EOF;
        this.dataSource = null;
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

    public void addBox(Box box) {
        this.boxes = new ArrayList(getBoxes());
        box.setParent(this);
        this.boxes.add(box);
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

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.lookahead == EOF) {
            return false;
        }
        if (this.lookahead != null) {
            return true;
        }
        try {
            this.lookahead = next();
            return true;
        } catch (NoSuchElementException e) {
            this.lookahead = EOF;
            return false;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public Box next() {
        Box parseBox;
        if (this.lookahead != null && this.lookahead != EOF) {
            Box box = this.lookahead;
            this.lookahead = null;
            return box;
        }
        LOG.logDebug("Parsing next() box");
        if (this.dataSource == null || this.parsePosition >= this.endPosition) {
            this.lookahead = EOF;
            throw new NoSuchElementException();
        }
        try {
            synchronized (this.dataSource) {
                this.dataSource.position(this.parsePosition);
                parseBox = this.boxParser.parseBox(this.dataSource, this);
                this.parsePosition = this.dataSource.position();
            }
            return parseBox;
        } catch (EOFException e) {
            throw new NoSuchElementException();
        } catch (IOException e2) {
            throw new NoSuchElementException();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName()).append("[");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.boxes.size()) {
                if (i2 > 0) {
                    sb.append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                }
                sb.append(this.boxes.get(i2).toString());
                i = i2 + 1;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }

    @Override // com.coremedia.iso.boxes.Container
    public final void writeContainer(WritableByteChannel writableByteChannel) throws IOException {
        for (Box box : getBoxes()) {
            box.getBox(writableByteChannel);
        }
    }

    @Override // com.coremedia.iso.boxes.Container
    public ByteBuffer getByteBuffer(long j, long j2) throws IOException {
        ByteBuffer map;
        synchronized (this.dataSource) {
            map = this.dataSource.map(this.startPosition + j, j2);
        }
        return map;
    }
}
