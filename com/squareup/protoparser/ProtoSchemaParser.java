package com.squareup.protoparser;

import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.squareup.protoparser.EnumType;
import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.Service;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public final class ProtoSchemaParser {
    private static final int MAX_TAG_VALUE = 536870911;
    private final char[] data;
    private final String fileName;
    private int line;
    private int lineStart;
    private String packageName;
    private int pos;
    private String prefix;
    private final List<String> dependencies = new ArrayList();
    private final List<Type> types = new ArrayList();
    private final List<Service> services = new ArrayList();
    private final List<ExtendDeclaration> extendDeclarations = new ArrayList();
    private final Map<String, Object> options = new LinkedHashMap();

    public static ProtoFile parse(File file) {
        return new ProtoSchemaParser(file.getName(), fileToCharArray(file)).readProtoFile();
    }

    public static ProtoFile parseUtf8(String str, InputStream inputStream) {
        return new ProtoSchemaParser(str, streamToCharArray(inputStream)).readProtoFile();
    }

    public static ProtoFile parse(String str, Reader reader) {
        return new ProtoSchemaParser(str, readerToCharArray(reader)).readProtoFile();
    }

    public static ProtoFile parse(String str, String str2) {
        return new ProtoSchemaParser(str, str2.toCharArray()).readProtoFile();
    }

    ProtoSchemaParser(String str, char[] cArr) {
        this.fileName = str;
        this.data = cArr;
    }

    private static char[] fileToCharArray(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return streamToCharArray(fileInputStream);
        } finally {
            fileInputStream.close();
        }
    }

    private static char[] streamToCharArray(InputStream inputStream) {
        return readerToCharArray(new InputStreamReader(inputStream, "UTF-8"));
    }

    private static char[] readerToCharArray(Reader reader) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        char[] cArr = new char[1024];
        while (true) {
            int read = reader.read(cArr);
            if (read != -1) {
                charArrayWriter.write(cArr, 0, read);
            } else {
                return charArrayWriter.toCharArray();
            }
        }
    }

    ProtoFile readProtoFile() {
        while (true) {
            String readDocumentation = readDocumentation();
            if (this.pos == this.data.length) {
                return new ProtoFile(this.fileName, this.packageName, this.dependencies, this.types, this.services, this.options, this.extendDeclarations);
            }
            Object readDeclaration = readDeclaration(readDocumentation, Context.FILE);
            if (readDeclaration instanceof Type) {
                this.types.add((Type) readDeclaration);
            } else if (readDeclaration instanceof Service) {
                this.services.add((Service) readDeclaration);
            } else if (readDeclaration instanceof Option) {
                Option option = (Option) readDeclaration;
                this.options.put(option.getName(), option.getValue());
            } else if (readDeclaration instanceof ExtendDeclaration) {
                this.extendDeclarations.add((ExtendDeclaration) readDeclaration);
            }
        }
    }

    private Object readDeclaration(String str, Context context) {
        char readChar;
        if (peekChar() == ';') {
            this.pos++;
            return null;
        }
        String readWord = readWord();
        if (readWord.equals("package")) {
            if (context.permitsPackage()) {
                if (this.packageName != null) {
                    throw unexpected("too many package names");
                }
                this.packageName = readName();
                this.prefix = this.packageName + ".";
                if (readChar() != ';') {
                    throw unexpected("expected ';'");
                }
                return null;
            }
            throw unexpected("package in " + context);
        } else if (readWord.equals("import")) {
            if (context.permitsImport()) {
                this.dependencies.add(readString());
                if (readChar() != ';') {
                    throw unexpected("expected ';'");
                }
                return null;
            }
            throw unexpected("import in " + context);
        } else if (readWord.equals("option")) {
            Option readOption = readOption('=');
            if (readChar() != ';') {
                throw unexpected("expected ';'");
            }
            return readOption;
        } else if (readWord.equals("message")) {
            return readMessage(str);
        } else {
            if (readWord.equals("enum")) {
                return readEnumType(str);
            }
            if (readWord.equals("service")) {
                return readService(str);
            }
            if (readWord.equals("extend")) {
                return readExtend(str);
            }
            if (readWord.equals("rpc")) {
                if (context.permitsRpc()) {
                    return readRpc(str);
                }
                throw unexpected("rpc in " + context);
            } else if (readWord.equals("required") || readWord.equals("optional") || readWord.equals("repeated")) {
                if (context.permitsField()) {
                    return readField(str, readWord);
                }
                throw unexpected("fields must be nested");
            } else if (readWord.equals("extensions")) {
                if (context.permitsExtensions()) {
                    return readExtensions(str);
                }
                throw unexpected("extensions must be nested");
            } else if (context == Context.ENUM) {
                ArrayList arrayList = new ArrayList();
                if (readChar() != '=') {
                    throw unexpected("expected '='");
                }
                int readInt = readInt();
                if (peekChar() == '[') {
                    readChar();
                    do {
                        arrayList.add(readOption('='));
                        readChar = readChar();
                        if (readChar == ']') {
                        }
                    } while (readChar == ',');
                    throw unexpected("Expected ',' or ']");
                }
                if (readChar() != ';') {
                    throw unexpected("expected ';'");
                }
                return new EnumType.Value(readWord, readInt, str, arrayList);
            } else {
                throw unexpected("unexpected label: " + readWord);
            }
        }
    }

    private MessageType readMessage(String str) {
        String str2 = this.prefix;
        String readName = readName();
        this.prefix += readName + ".";
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (readChar() != '{') {
            throw unexpected("expected '{'");
        }
        while (true) {
            String readDocumentation = readDocumentation();
            if (peekChar() == '}') {
                this.pos++;
                this.prefix = str2;
                return new MessageType(readName, this.prefix + readName, str, arrayList, arrayList2, arrayList3, arrayList4);
            }
            Object readDeclaration = readDeclaration(readDocumentation, Context.MESSAGE);
            if (readDeclaration instanceof MessageType.Field) {
                arrayList.add((MessageType.Field) readDeclaration);
            } else if (readDeclaration instanceof Type) {
                arrayList2.add((Type) readDeclaration);
            } else if (readDeclaration instanceof Extensions) {
                arrayList3.add((Extensions) readDeclaration);
            } else if (readDeclaration instanceof Option) {
                arrayList4.add((Option) readDeclaration);
            }
        }
    }

    private ExtendDeclaration readExtend(String str) {
        String readName = readName();
        ArrayList arrayList = new ArrayList();
        if (readChar() != '{') {
            throw unexpected("expected '{'");
        }
        while (true) {
            String readDocumentation = readDocumentation();
            if (peekChar() == '}') {
                break;
            }
            Object readDeclaration = readDeclaration(readDocumentation, Context.EXTEND);
            if (readDeclaration instanceof MessageType.Field) {
                arrayList.add((MessageType.Field) readDeclaration);
            }
        }
        this.pos++;
        return new ExtendDeclaration(readName, readName.contains(".") ? readName : this.prefix + readName, str, arrayList);
    }

    private Service readService(String str) {
        String readName = readName();
        ArrayList arrayList = new ArrayList();
        if (readChar() != '{') {
            throw unexpected("expected '{'");
        }
        while (true) {
            String readDocumentation = readDocumentation();
            if (peekChar() == '}') {
                this.pos++;
                return new Service(readName, str, arrayList);
            }
            Object readDeclaration = readDeclaration(readDocumentation, Context.SERVICE);
            if (readDeclaration instanceof Service.Method) {
                arrayList.add((Service.Method) readDeclaration);
            }
        }
    }

    private EnumType readEnumType(String str) {
        String readName = readName();
        ArrayList arrayList = new ArrayList();
        if (readChar() != '{') {
            throw unexpected("expected '{'");
        }
        while (true) {
            String readDocumentation = readDocumentation();
            if (peekChar() == '}') {
                this.pos++;
                return new EnumType(readName, this.prefix + readName, str, arrayList);
            }
            Object readDeclaration = readDeclaration(readDocumentation, Context.ENUM);
            if (readDeclaration instanceof EnumType.Value) {
                arrayList.add((EnumType.Value) readDeclaration);
            }
        }
    }

    private MessageType.Field readField(String str, String str2) {
        MessageType.Label valueOf = MessageType.Label.valueOf(str2.toUpperCase(Locale.US));
        String readName = readName();
        String readName2 = readName();
        if (readChar() != '=') {
            throw unexpected("expected '='");
        }
        int readInt = readInt();
        if (readInt <= 0) {
            throw unexpected("expected tag > 0");
        }
        ArrayList arrayList = new ArrayList();
        if (peekChar() == '[') {
            this.pos++;
            while (true) {
                arrayList.add(readOption('='));
                char peekChar = peekChar();
                if (peekChar == ']') {
                    break;
                } else if (peekChar == ',') {
                    this.pos++;
                }
            }
            this.pos++;
        }
        if (readChar() == ';') {
            this.pos++;
            return new MessageType.Field(valueOf, readName, readName2, readInt, str, arrayList);
        }
        throw unexpected("expected ';'");
    }

    private Extensions readExtensions(String str) {
        int i;
        int readInt = readInt();
        if (peekChar() != ';') {
            readWord();
            String readWord = readWord();
            if (readWord.equals("max")) {
                i = MAX_TAG_VALUE;
            } else {
                i = Integer.parseInt(readWord);
            }
        } else {
            i = readInt;
        }
        if (readChar() != ';') {
            throw unexpected("expected ';'");
        }
        return new Extensions(str, readInt, i);
    }

    private Option readOption(char c) {
        String str;
        boolean z = peekChar() == '[';
        String readName = readName();
        String str2 = z ? "[" + readName + "]" : readName;
        char readChar = readChar();
        if (readChar != '.') {
            str = null;
        } else {
            String readName2 = readName();
            readChar = readChar();
            str = readName2;
        }
        if (readChar != c) {
            throw unexpected("expected '" + c + "' in option");
        }
        Object readValue = readValue();
        return new Option(str2, str != null ? new Option(str, readValue) : readValue);
    }

    private Object readValue() {
        switch (peekChar()) {
            case '[':
                return readList();
            case '{':
                return readMap('{', '}', ':');
            default:
                return readString();
        }
    }

    private Map<String, Object> readMap(char c, char c2, char c3) {
        LinkedHashMap linkedHashMap;
        if (readChar() != c) {
            throw new AssertionError();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        while (peekChar() != c2) {
            Option readOption = readOption(c3);
            String name = readOption.getName();
            Object value = readOption.getValue();
            if (value instanceof Option) {
                Map map = (Map) linkedHashMap2.get(name);
                if (map == null) {
                    LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                    linkedHashMap2.put(name, linkedHashMap3);
                    linkedHashMap = linkedHashMap3;
                } else {
                    linkedHashMap = map;
                }
                Option option = (Option) value;
                linkedHashMap.put(option.getName(), option.getValue());
            } else {
                Object obj = linkedHashMap2.get(name);
                if (obj == null) {
                    linkedHashMap2.put(name, value);
                } else if (obj instanceof List) {
                    addToList((List) obj, value);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj);
                    addToList(arrayList, value);
                    linkedHashMap2.put(name, arrayList);
                }
            }
            if (peekChar() == ',') {
                this.pos++;
            }
        }
        this.pos++;
        return linkedHashMap2;
    }

    private void addToList(List<Object> list, Object obj) {
        if (obj instanceof List) {
            list.addAll((List) obj);
        } else {
            list.add(obj);
        }
    }

    private List<Object> readList() {
        if (readChar() != '[') {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        while (peekChar() != ']') {
            arrayList.add(readValue());
            char peekChar = peekChar();
            if (peekChar == ',') {
                this.pos++;
            } else if (peekChar != ']') {
                throw unexpected("expected ',' or ']'");
            }
        }
        this.pos++;
        return arrayList;
    }

    private Service.Method readRpc(String str) {
        String readName = readName();
        if (readChar() != '(') {
            throw unexpected("expected '('");
        }
        String readName2 = readName();
        if (readChar() != ')') {
            throw unexpected("expected ')'");
        }
        if (readWord().equals("returns")) {
            if (readChar() != '(') {
                throw unexpected("expected '('");
            }
            String readName3 = readName();
            if (readChar() != ')') {
                throw unexpected("expected ')'");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (peekChar() == '{') {
                this.pos++;
                while (true) {
                    String readDocumentation = readDocumentation();
                    if (peekChar() == '}') {
                        break;
                    }
                    Object readDeclaration = readDeclaration(readDocumentation, Context.RPC);
                    if (readDeclaration instanceof Option) {
                        Option option = (Option) readDeclaration;
                        linkedHashMap.put(option.getName(), option.getValue());
                    }
                }
                this.pos++;
            } else if (readChar() != ';') {
                throw unexpected("expected ';'");
            }
            return new Service.Method(readName, str, readName2, readName3, linkedHashMap);
        }
        throw unexpected("expected 'returns'");
    }

    private char readChar() {
        char peekChar = peekChar();
        this.pos++;
        return peekChar;
    }

    private char peekChar() {
        skipWhitespace(true);
        if (this.pos == this.data.length) {
            throw unexpected("unexpected end of file");
        }
        return this.data[this.pos];
    }

    private String readString() {
        skipWhitespace(true);
        return peekChar() == '\"' ? readQuotedString() : readWord();
    }

    private String readQuotedString() {
        if (readChar() != '\"') {
            throw new AssertionError();
        }
        StringBuilder sb = new StringBuilder();
        while (this.pos < this.data.length) {
            char[] cArr = this.data;
            int i = this.pos;
            this.pos = i + 1;
            char c = cArr[i];
            if (c == '\"') {
                return sb.toString();
            }
            if (c == '\\') {
                if (this.pos != this.data.length) {
                    char[] cArr2 = this.data;
                    int i2 = this.pos;
                    this.pos = i2 + 1;
                    c = cArr2[i2];
                    switch (c) {
                        case '0':
                        case '1':
                        case TbadkApplication.MEMORY_FOURM_COUNT /* 50 */:
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                            this.pos--;
                            c = readNumericEscape(8, 3);
                            break;
                        case 'X':
                        case 'x':
                            c = readNumericEscape(16, 2);
                            break;
                        case 'a':
                            c = 7;
                            break;
                        case 'b':
                            c = '\b';
                            break;
                        case 'f':
                            c = '\f';
                            break;
                        case 'n':
                            c = '\n';
                            break;
                        case Constants.MEDIA_CLOSED /* 114 */:
                            c = '\r';
                            break;
                        case 't':
                            c = '\t';
                            break;
                        case 'v':
                            c = 11;
                            break;
                    }
                } else {
                    throw unexpected("unexpected end of file");
                }
            }
            sb.append(c);
            if (c == '\n') {
                newline();
            }
        }
        throw unexpected("unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
        throw unexpected("expected a digit after \\x or \\X");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private char readNumericEscape(int i, int i2) {
        int hexDigit;
        int min = Math.min(this.pos + i2, this.data.length);
        int i3 = -1;
        while (this.pos < min && (hexDigit = hexDigit(this.data[this.pos])) != -1 && hexDigit < i) {
            i3 = i3 < 0 ? hexDigit : (i3 * i) + hexDigit;
            this.pos++;
        }
        return (char) i3;
    }

    private int hexDigit(char c) {
        if (c < '0' || c > '9') {
            if (c < 'a' || c > 'f') {
                if (c < 'A' || c > 'F') {
                    return -1;
                }
                return (c - 'A') + 10;
            }
            return (c - 'a') + 10;
        }
        return c - '0';
    }

    private String readName() {
        char peekChar = peekChar();
        if (peekChar == '(') {
            this.pos++;
            String readWord = readWord();
            if (readChar() != ')') {
                throw unexpected("expected ')'");
            }
            return readWord;
        } else if (peekChar == '[') {
            this.pos++;
            String readWord2 = readWord();
            if (readChar() != ']') {
                throw unexpected("expected ']'");
            }
            return readWord2;
        } else {
            return readWord();
        }
    }

    private String readWord() {
        char c;
        skipWhitespace(true);
        int i = this.pos;
        while (this.pos < this.data.length && (((c = this.data[this.pos]) >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == '_' || c == '-' || c == '.')))) {
            this.pos++;
        }
        if (i == this.pos) {
            throw unexpected("expected a word");
        }
        return new String(this.data, i, this.pos - i);
    }

    private int readInt() {
        String readWord = readWord();
        int i = 10;
        try {
            if (readWord.startsWith("0x")) {
                readWord = readWord.substring("0x".length());
                i = 16;
            }
            return Integer.valueOf(readWord, i).intValue();
        } catch (Exception e) {
            throw unexpected("expected an integer but was " + readWord);
        }
    }

    private String readDocumentation() {
        String str = null;
        while (true) {
            skipWhitespace(false);
            if (this.pos == this.data.length || this.data[this.pos] != '/') {
                break;
            }
            String readComment = readComment();
            str = str == null ? readComment : str + IOUtils.LINE_SEPARATOR_UNIX + readComment;
        }
        return str != null ? str : "";
    }

    private String readComment() {
        char c;
        if (this.pos == this.data.length || this.data[this.pos] != '/') {
            throw new AssertionError();
        }
        this.pos++;
        if (this.pos < this.data.length) {
            char[] cArr = this.data;
            int i = this.pos;
            this.pos = i + 1;
            c = cArr[i];
        } else {
            c = 65535;
        }
        if (c == '*') {
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            while (this.pos + 1 < this.data.length) {
                char c2 = this.data[this.pos];
                if (c2 == '*' && this.data[this.pos + 1] == '/') {
                    this.pos += 2;
                    return sb.toString().trim();
                }
                if (c2 == '\n') {
                    sb.append('\n');
                    newline();
                    z = true;
                } else if (!z) {
                    sb.append(c2);
                } else if (c2 == '*') {
                    if (this.data[this.pos + 1] == ' ') {
                        this.pos++;
                    }
                    z = false;
                } else if (!Character.isWhitespace(c2)) {
                    sb.append(c2);
                    z = false;
                }
                this.pos++;
            }
            throw unexpected("unterminated comment");
        } else if (c == '/') {
            if (this.pos < this.data.length && this.data[this.pos] == ' ') {
                this.pos++;
            }
            int i2 = this.pos;
            while (true) {
                if (this.pos >= this.data.length) {
                    break;
                }
                char[] cArr2 = this.data;
                int i3 = this.pos;
                this.pos = i3 + 1;
                if (cArr2[i3] == '\n') {
                    newline();
                    break;
                }
            }
            return new String(this.data, i2, (this.pos - 1) - i2);
        } else {
            throw unexpected("unexpected '/'");
        }
    }

    private void skipWhitespace(boolean z) {
        while (this.pos < this.data.length) {
            char c = this.data[this.pos];
            if (c == ' ' || c == '\t' || c == '\r' || c == '\n') {
                this.pos++;
                if (c == '\n') {
                    newline();
                }
            } else if (z && c == '/') {
                readComment();
            } else {
                return;
            }
        }
    }

    private void newline() {
        this.line++;
        this.lineStart = this.pos;
    }

    private int column() {
        return (this.pos - this.lineStart) + 1;
    }

    private int line() {
        return this.line + 1;
    }

    private RuntimeException unexpected(String str) {
        throw new IllegalStateException(String.format("Syntax error in %s at %d:%d: %s", this.fileName, Integer.valueOf(line()), Integer.valueOf(column()), str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Context {
        FILE,
        MESSAGE,
        ENUM,
        RPC,
        EXTEND,
        SERVICE;

        public boolean permitsPackage() {
            return this == FILE;
        }

        public boolean permitsImport() {
            return this == FILE;
        }

        public boolean permitsField() {
            return this == MESSAGE || this == EXTEND;
        }

        public boolean permitsExtensions() {
            return this != FILE;
        }

        public boolean permitsRpc() {
            return this == SERVICE;
        }
    }
}
