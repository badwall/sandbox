package vm.trello.data;

import java.util.Objects;

public class BoardData {

    private String boardId;
    private String boardName;
    private String boardNameURL;

    public BoardData(String boardId, String boardName, String boardNameURL) {
        this.boardId = boardId;
        this.boardName = boardName;
        this.boardNameURL = boardNameURL;
    }

    @Override
    public String toString() {
        return "BoardData{" +
                "boardId='" + boardId + '\'' +
                ", boardName='" + boardName + '\'' +
                ", boardNameURL='" + boardNameURL + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardData boardData = (BoardData) o;
        return Objects.equals(boardId, boardData.boardId) &&
                Objects.equals(boardName, boardData.boardName) &&
                Objects.equals(boardNameURL, boardData.boardNameURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boardId, boardName, boardNameURL);
    }

    public String getBoardId() {
        return boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public String getBoardNameURL() {
        return boardNameURL;
    }
}
