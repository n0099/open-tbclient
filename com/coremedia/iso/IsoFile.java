package com.coremedia.iso;

import com.coremedia.iso.boxes.Box;
import com.coremedia.iso.boxes.MovieBox;
import com.googlecode.mp4parser.BasicContainer;
import com.googlecode.mp4parser.DataSource;
import com.googlecode.mp4parser.FileDataSourceImpl;
import com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.googlecode.mp4parser.util.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.WritableByteChannel;
@DoNotParseDetail
/* loaded from: classes6.dex */
public class IsoFile extends BasicContainer implements Closeable {
    public static Logger LOG = Logger.getLogger(IsoFile.class);

    public IsoFile(String str) throws IOException {
        this(new FileDataSourceImpl(new File(str)));
    }

    public static String bytesToFourCC(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        if (bArr != null) {
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 4));
        }
        try {
            return new String(bArr2, "ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new Error("Required character encoding is missing", e2);
        }
    }

    public static byte[] fourCCtoBytes(String str) {
        byte[] bArr = new byte[4];
        if (str != null) {
            for (int i2 = 0; i2 < Math.min(4, str.length()); i2++) {
                bArr[i2] = (byte) str.charAt(i2);
            }
        }
        return bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.dataSource.close();
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writeContainer(writableByteChannel);
    }

    public MovieBox getMovieBox() {
        for (Box box : getBoxes()) {
            if (box instanceof MovieBox) {
                return (MovieBox) box;
            }
        }
        return null;
    }

    public long getSize() {
        return getContainerSize();
    }

    @Override // com.googlecode.mp4parser.BasicContainer
    public String toString() {
        return "IsoFile[" + this.dataSource.toString() + "]";
    }

    public IsoFile(DataSource dataSource) throws IOException {
        parseContainer(dataSource, dataSource.size(), new PropertyBoxParserImpl(new String[0]));
    }

    public IsoFile(DataSource dataSource, BoxParser boxParser) throws IOException {
        this.dataSource = dataSource;
        this.boxParser = boxParser;
    }
}
